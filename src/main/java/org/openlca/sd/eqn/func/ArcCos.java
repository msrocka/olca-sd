package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.commons.Res;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.cells.Cell;

public class ArcCos implements Func {

	private final Id name = Id.of("ARCCOS");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double v = arg.asNum();
				if (v < -1.0 || v > 1.0) {
					return Res.error(
						"ARCCOS domain error: input must be in range [-1, 1], got " + v);
				}
				double result = Math.acos(v);
				return Res.ok(Cell.of(result));
			}

			return arg.isTensorCell()
				? Fn.each(this, arg.asTensorCell())
				: Res.error("ARCCOS is not defined for: " + arg);
		});
	}

}
