package org.openlca.sd.eqn.cells;

import org.openlca.sd.eqn.Interpreter;
import org.openlca.util.Res;

public record EmptyCell() implements Cell {
	private static final EmptyCell _instance = new EmptyCell();

	static EmptyCell get() {
		return _instance;
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		return Res.of(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof EmptyCell;
	}

	@Override
	public String toString() {
		return "{}";
	}
}
