package org.openlca.sd.eqn.cells;

import java.util.List;

import org.openlca.sd.eqn.LookupFunc;
import org.openlca.sd.eqn.Subscript;

public record LookupCell(
	String eqn, LookupFunc func, List<Subscript> subscripts
) implements Cell {

	@Override
	public String toString() {
		return "lookup{'" + eqn + "'}";
	}
}