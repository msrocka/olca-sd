package org.openlca.sd.eqn.cells;

public record EqnCell(String value) implements Cell {

	@Override
	public String toString() {
		return "{'" + value + "'}";
	}
}
