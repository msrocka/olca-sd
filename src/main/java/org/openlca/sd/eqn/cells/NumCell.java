package org.openlca.sd.eqn.cells;

public record NumCell(double value) implements Cell {

	@Override
	public String toString() {
		return "{" + value + "}";
	}
}
