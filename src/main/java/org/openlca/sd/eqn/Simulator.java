package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.openlca.sd.eqn.Var.Aux;
import org.openlca.sd.eqn.Var.Stock;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.sd.eqn.func.Add;
import org.openlca.sd.eqn.func.Mul;
import org.openlca.sd.eqn.func.Sub;
import org.openlca.sd.xmile.Xmile;
import org.openlca.util.Res;

public class Simulator {

	private final TimeSeq time;
	private final List<Var> vars;
	private final Map<Id, Var> state;

	private final EvalContext ctx;
	private final Aux timeVar;
	private final Interpreter interpreter;

	private Simulator(TimeSeq time, List<Var> vars) {
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

		timeVar = new Aux(Id.of("TIME"), Cell.of(time.start()));
		ctx.bind(timeVar);
		for (var v : vars) {
			ctx.bind(v);
		}

		interpreter = Interpreter.of(ctx);
	}

	public static Res<Simulator> of(Xmile xmile) {
		var time = TimeSeq.of(xmile);
		if (time.hasError())
			return time.wrapError("failed to parse time from simulation spec");
		var vars = Vars.readFrom(xmile);
		if (vars.hasError())
			return vars.wrapError("failed to parse simulation elements");
		var order = EvaluationOrder.of(vars.value());
		if (order.hasError())
			return order.wrapError("failed to determine evaluation order");
		return Res.of(new Simulator(time.value(), order.value()));
	}

	public List<Var> vars() {
		return vars;
	}

	public Interpreter interpreter() {
		return interpreter;
	}

	public void forEach(Consumer<Res<SimulationState>> fn) {
		if (fn == null)
			return;

    // TODO: bind top-level lookup functions
		// maybe in each iteration bind SELF to the var
		// that is currently evaluated

		// initialisation
		timeVar.pushValue(timeVar.value());
		var stocks = new ArrayList<Stock>();
		var evalVars = new ArrayList<Var>();
		for (var v : vars) {
			var res = interpreter.eval(v.def());
			if (res.hasError()) {
				fn.accept(res.wrapError("initialization of variable '"
					+ v.name().label() + "' failed"));
				return;
			}

			v.pushValue(res.value());
			if (v instanceof Stock stock) {
				stocks.add(stock);
			} else {
				evalVars.add(v);
			}
		}
		fn.accept(Res.of(new SimulationState(0, time.current(), state)));

		var dt = Cell.of(time.dt());
		int i = 0;
		while (!time.isFinished()) {

			timeVar.pushValue(Cell.of(time.next()));

			// evaluate the variables
			for (var v : evalVars) {
				var res = interpreter.eval(v.def());
				if (res.hasError()) {
					fn.accept(res.wrapError("evaluation error at t=" + time.current()));
					return;
				}
				v.pushValue(res.value());
			}

			// update the stocks
			// TODO: array projections
			for (var stock : stocks) {
				var val = stock.value();

				// adding the in-flows
				for (var inFlowId : stock.inFlows()) {
					var inFlow = ctx.getVar(inFlowId).orElse(null);
					if (inFlow == null) {
						fn.accept(Res.error("unknown in-flow '" + inFlowId
							+ "' of stock: " + stock.name()));
						return;
					}

					var inFlowDelta = Mul.apply(inFlow.value(), dt);
					if (inFlowDelta.hasError()) {
						fn.accept(Res.error("failed to calculate " + inFlowId + " * dt"));
						return;
					}

					var nextVal = Add.apply(val, inFlowDelta.value());
					if (nextVal.hasError()) {
						fn.accept(nextVal.wrapError("failed to add flow " + inFlowId
							+ " to stock " + stock.name()));
						return;
					}
					val = nextVal.value();
				}

				//  subtract the out-flows
				for (var outFlowId : stock.outFlows()) {
					var outFlow = ctx.getVar(outFlowId).orElse(null);
					if (outFlow == null) {
						fn.accept(Res.error("unknown out-flow '" + outFlowId
							+ "' of stock: " + stock.name()));
						return;
					}

					var outFlowDelta = Mul.apply(outFlow.value(), dt);
					if (outFlowDelta.hasError()) {
						fn.accept(Res.error("failed to calculate " + outFlowId + " * dt"));
						return;
					}

					var nextVal = Sub.apply(val, outFlowDelta.value());
					if (nextVal.hasError()) {
						fn.accept(nextVal.wrapError("failed to subtract out-flow " + outFlowId
							+ " from stock " + stock.name()));
						return;
					}
					val = nextVal.value();
				}

				stock.pushValue(val);
			}

			i++;
			fn.accept(Res.of(new SimulationState(i, time.current(), state)));
		}
	}
}
