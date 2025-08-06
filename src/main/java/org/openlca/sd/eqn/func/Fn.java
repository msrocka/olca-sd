package org.openlca.sd.eqn.func;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

class Fn {

	private Fn() {
	}

	static Res<Cell> withOneArg(
		List<Cell> args, Function<Cell, Res<Cell>> fn
	) {
		if (args == null || args.size() != 1)
			return Res.error("function requires exactly 1 argument");
		var a = args.getFirst();
		if (a == null)
			return Res.error("function argument cannot be null");
		return fn.apply(a);
	}

	static Res<Cell> withTwoArgs(
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
