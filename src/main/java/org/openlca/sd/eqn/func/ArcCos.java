package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;

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
				double value = arg.asNum();
				if (value < -1.0 || value > 1.0) {
					return Res.error("ARCCOS domain error: input must be in range [-1, 1], got " + value);
				}
				double result = Math.acos(value);
				return Res.of(Cell.of(result));
			}

			if (arg.isTensorCell()) {
				return Fn.each(arg.asTensorCell(),
					element -> apply(List.of(element)),
					"arccosine");
			}

			return Res.error("ARCCOS is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

}
