package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.util.Res;

public class Abs implements Func {

	private final Id name = Id.of("ABS");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {
			if (arg.isNumCell()) {
				double result = Math.abs(arg.asNum());
				return Res.of(Cell.of(result));
			}
			return arg.isTensorCell()
				? Fn.each(this, arg.asTensorCell())
				: Res.error("ABS is not defined for: " + arg);
		});
	}

}
