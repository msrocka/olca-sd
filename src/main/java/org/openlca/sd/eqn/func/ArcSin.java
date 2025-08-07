package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

public class ArcSin implements Func {

	private final Id name = Id.of("ARCSIN");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double value = arg.asNum();
				if (value < -1.0 || value > 1.0) {
					return Res.error("ARCSIN domain error: input must be in range [-1, 1], got " + value);
				}
				double result = Math.asin(value);
				return Res.of(Cell.of(result));
			}

			return arg.isTensorCell()
				? Fn.each(this, arg.asTensorCell())
				: Res.error("ARCSIN is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
