package org.openlca.sd.eqn.func;

import java.util.List;

import org.apache.commons.math3.distribution.PoissonDistribution;
import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.NumCell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

public class Poisson implements Func {

	private final Id name = Id.of("POISSON");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.isEmpty())
			return Res.error("POISSON needs a mean value as first argument");
		var arg = args.getFirst();
		if (!(arg instanceof NumCell(double mean)))
			return Res.error("POISSON expects numeric arguments but got: " + arg);
		var value = new PoissonDistribution(mean).sample();
		return Res.of(Cell.of(value));
	}
}
