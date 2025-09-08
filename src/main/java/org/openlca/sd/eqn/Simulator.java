package org.openlca.sd.eqn;

import java.util.List;

import org.openlca.sd.util.Res;
import org.openlca.sd.xmile.Xmile;

public class Simulator {

	private final TimeSeq time;
	private final List<Var> vars;

	private Simulator(TimeSeq time, List<Var> vars) {
		this.time = time;
		this.vars = vars;
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

	public Res<Void> run() {

		return Res.error("no yet implemented");
	}

}
