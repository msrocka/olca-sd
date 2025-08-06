package org.openlca.sd.eqn.func;

import java.util.List;
import java.util.function.BiFunction;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

class Fn {

	private Fn() {
	}

	static Res<Cell> with2Args(
		List<Cell> args, BiFunction<Cell, Cell, Res<Cell>> fn
	) {
		if (args == null || args.size() != 2)
			return Res.error("function requires exactly 2 arguments");
		var a = args.getFirst();
		var b = args.getLast();
		if (a == null || b == null)
			return Res.error("function arguments cannot be null");
		return fn.apply(a, b);
	}

}
