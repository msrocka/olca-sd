package org.openlca.sd.eqn.cells;

import java.util.Objects;

import org.openlca.sd.eqn.Interpreter;
import org.openlca.util.Res;

public record EqnCell(String value) implements Cell {

	public EqnCell {
		Objects.requireNonNull(value);
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		return interpreter.eval(value);
	}

	@Override
	public String toString() {
		return "{'" + value + "'}";
	}
}
