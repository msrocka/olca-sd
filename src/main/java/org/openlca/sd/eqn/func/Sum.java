package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.util.Res;

public class Sum implements Func {

	private final Id name = Id.of("SUM");

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.isEmpty())
			return Res.error("sum function requires at least one argument");
		if (args.size() == 1)
			return Res.of(args.getFirst());
		var acc = args.getFirst();
		var add = new Add();
		for (int i = 1; i < args.size(); i++) {
			var s = add.apply(List.of(acc, args.get(i)));
			if (s.hasError())
				return s.wrapError("error in sum at argument " + (i + 1));
			acc = s.value();
		}
		return Res.of(acc);
	}

}
