package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

public class Ln implements Func {

	private final Id name = Id.of("LN");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double value = arg.asNum();
				if (value <= 0.0) {
					return Res.error("LN domain error: input must be positive, got " + value);
				}
				double result = Math.log(value);
				return Res.of(Cell.of(result));
			}

			return arg.isTensorCell()
				? Fn.each(this, arg.asTensorCell())
				: Res.error("LN is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
