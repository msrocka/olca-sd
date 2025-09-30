package org.openlca.sd.eqn.cells;

public record NonNegativeCell(Cell value) implements Cell {

	@Override
	public String toString() {
		return value == null
			? "nonNeg{}"
			: "nonNeg{" + value + "}";
	}

}
