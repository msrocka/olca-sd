package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

public class Sqrt implements Func {

	private final Id name = Id.of("SQRT");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double value = arg.asNum();
				if (value < 0.0) {
					return Res.error("SQRT domain error: input must be non-negative, got " + value);
				}
				double result = Math.sqrt(value);
				return Res.of(Cell.of(result));
			}

			return arg.isTensorCell()
				? Fn.each(this, arg.asTensorCell())
				: Res.error("SQRT is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
