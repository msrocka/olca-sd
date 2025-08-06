package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

public class Log10 implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double value = arg.asNum();
				if (value <= 0.0) {
					return Res.error("LOG10 domain error: input must be positive, got " + value);
				}
				double result = Math.log10(value);
				return Res.of(Cell.of(result));
			}

			if (arg.isTensorCell()) {
				return Fn.each(arg.asTensorCell(),
					element -> apply(List.of(element)),
					"base-10 logarithm");
			}

			return Res.error("LOG10 is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
