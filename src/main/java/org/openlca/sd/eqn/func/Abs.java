package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

public class Abs implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double result = Math.abs(arg.asNum());
				return Res.of(Cell.of(result));
			}

			if (arg.isTensorCell()) {
				return Fn.each(
					arg.asTensorCell(),
					element -> apply(List.of(element)),
					"absolute value");
			}

			return Res.error("ABS is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
