package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

public class ArcTan implements Func {

	private final Id name = Id.of("ARCTAN");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			if (arg.isNumCell()) {
				double result = Math.atan(arg.asNum());
				return Res.of(Cell.of(result));
			}

			if (arg.isTensorCell()) {
				return Fn.each(arg.asTensorCell(),
					element -> apply(List.of(element)),
					"arctangent");
			}

			return Res.error("ARCTAN is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
