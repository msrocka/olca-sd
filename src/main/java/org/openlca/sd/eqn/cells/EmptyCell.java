package org.openlca.sd.eqn.cells;

public record EmptyCell() implements Cell {
	private static final EmptyCell _instance = new EmptyCell();

	static EmptyCell get() {
		return _instance;
	}

	@Override
	public boolean equals(Object other) {
		return other == this
			|| (other instanceof Cell cell && cell.isEmpty());
	}

	@Override
	public String toString() {
		return "{}";
	}
}