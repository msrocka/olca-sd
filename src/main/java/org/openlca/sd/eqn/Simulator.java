package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openlca.sd.eqn.Var.Aux;
import org.openlca.sd.eqn.Var.Stock;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.sd.eqn.func.Add;
import org.openlca.sd.eqn.func.Mul;
import org.openlca.sd.eqn.func.Sub;
import org.openlca.sd.xmile.Xmile;
import org.openlca.util.Res;

public class Simulator implements Iterable<Res<SimulationState>> {

	private final TimeSeq time;
	private final List<Var> vars;

	private Simulator(TimeSeq time, List<Var> vars) {
		this.time = time;
		this.vars = vars;
	}

	public static Res<Simulator> of(Xmile xmile) {
		var time = TimeSeq.of(xmile);
		if (time.hasError()) {
			return time.wrapError("failed to parse time from simulation spec");
		}
		var vars = Vars.readFrom(xmile);
		if (vars.hasError()) {
			return vars.wrapError("failed to parse simulation elements");
		}
		var order = EvaluationOrder.of(vars.value());
		if (order.hasError()) {
			return order.wrapError("failed to determine evaluation order");
		}
		return Res.of(new Simulator(time.value(), order.value()));
	}

	@Override
	public Simulation iterator() {
		var freshVars = new ArrayList<Var>(vars.size());
		for (var v : vars) {
			freshVars.add(v.freshCopy());
		}
		return new Simulation(time, freshVars);
	}

	public static class Simulation implements Iterator<Res<SimulationState>> {

		private final TimeSeq time;
		private final List<Var> vars;
		private final Map<Id, Var> state;

		private final EvalContext ctx;
		private final Aux timeVar;
		private final Cell dt;
		private final Interpreter interpreter;

		private boolean isInitialized = false;
		private int iteration;
		private final List<Stock> stocks = new ArrayList<>();
		private final List<Var> evalVars = new ArrayList<>();

		private Simulation(TimeSeq time, List<Var> vars) {
			this.time = time;
			this.vars = vars;
			this.state = new HashMap<>();
			for (var v : vars) {
				state.put(v.name(), v);
			}

			ctx = new EvalContext();
			ctx.bind("INF", Double.POSITIVE_INFINITY);
			ctx.bind("PI", Math.PI);
			ctx.bind("DT", time.dt());
			ctx.bind("STARTTIME", time.start());
			ctx.bind("STOPTIME", time.end());
			// TODO: bind top-level lookup functions

			timeVar = new Aux(Id.of("TIME"), Cell.of(time.start()));
			dt = Cell.of(time.dt());
			ctx.bind(timeVar);
			for (var v : vars) {
				ctx.bind(v);
			}

			interpreter = Interpreter.of(ctx);
		}

		public Interpreter interpreter() {
			return interpreter;
		}

		@Override
		public boolean hasNext() {
			return !time.isFinished();
		}

		@Override
		public Res<SimulationState> next() {
			if (time.isFinished()) {
				throw new IllegalStateException("simulation finished");
			}
			return !isInitialized
				? initialize()
				: nextState();
		}

		private Res<SimulationState> initialize() {
			isInitialized = true;
			timeVar.pushValue(Cell.of(time.start()));

			for (var v : vars) {
				var res = v.def().eval(interpreter);
				if (res.hasError()) {
					return res.wrapError("Initialization of variable '"
						+ v.name().label() + "' failed");
				}
				v.pushValue(res.value());
				if (v instanceof Stock stock) {
					stocks.add(stock);
				} else {
					evalVars.add(v);
				}
			}
			return Res.of(new SimulationState(0, time.current(), state));
		}

		private Res<SimulationState> nextState() {

			// update the stocks
			// TODO: array projections
			for (var stock : stocks) {
				var val = stock.value();

				// adding the in-flows
				for (var inFlowId : stock.inFlows()) {
					var inFlow = ctx.getVar(inFlowId).orElse(null);
					if (inFlow == null) {
						return Res.error("Unknown in-flow '" + inFlowId
							+ "' of stock: " + stock.name());
					}

					var inFlowDelta = Mul.apply(inFlow.value(), dt);
					if (inFlowDelta.hasError())
						return Res.error("Failed to calculate: dt * " + inFlowId);

					var nextVal = Add.apply(val, inFlowDelta.value());
					if (nextVal.hasError()) {
						return nextVal.wrapError("Failed to add flow " + inFlowId
							+ " to stock " + stock.name());
					}
					val = nextVal.value();
				}

				// subtracting the out-flows
				for (var outFlowId : stock.outFlows()) {
					var outFlow = ctx.getVar(outFlowId).orElse(null);
					if (outFlow == null) {
						return Res.error("Unknown out-flow '" + outFlowId
							+ "' of stock: " + stock.name());
					}

					var outFlowDelta = Mul.apply(outFlow.value(), dt);
					if (outFlowDelta.hasError())
						return Res.error("Failed to calculate: dt * " + outFlowId);

					var nextVal = Sub.apply(val, outFlowDelta.value());
					if (nextVal.hasError()) {
						return nextVal.wrapError("Failed to subtract out-flow " + outFlowId
							+ " from stock " + stock.name());
					}
					val = nextVal.value();
				}

				stock.pushValue(val);
			}

			// evaluate the variables
			for (var v : evalVars) {
				var res = v.def().eval(interpreter);
				if (res.hasError())
					return res.wrapError("Evaluation error for variable: " + v.name());
				v.pushValue(res.value());
			}

			iteration++;
			timeVar.pushValue(Cell.of(time.next()));
			return Res.of(new SimulationState(iteration, time.current(), state));
		}
	}
}
