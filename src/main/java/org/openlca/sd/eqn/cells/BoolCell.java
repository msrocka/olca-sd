package org.openlca.sd.eqn.cells;

public record BoolCell(boolean value) implements Cell {

	@Override
	public String toString() {
		return "{" + value + "}";
	}
}
