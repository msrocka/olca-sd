package org.openlca.sd.eqn.func;

import java.util.List;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.sd.eqn.cells.Cell.NumCell;
import org.openlca.util.Res;

public class ExpRnd implements Func {

	private final Id name = Id.of("EXPRND");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.isEmpty())
			return Res.error("EXPRND needs a mean value as first argument");
		var arg = args.getFirst();
		if (!(arg instanceof NumCell(double mean)))
			return Res.error("EXPRND expects numeric arguments but got: " + arg);
		var value = new ExponentialDistribution(mean).sample();
		return Res.of(Cell.of(value));
	}
}
