package org.openlca.sd.eqn.cells;

import org.openlca.sd.eqn.Interpreter;
import org.openlca.util.Res;

public record NumCell(double value) implements Cell {

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		return Res.of(new NumCell(value));
	}

	@Override
	public String toString() {
		return "{" + value + "}";
	}
}
