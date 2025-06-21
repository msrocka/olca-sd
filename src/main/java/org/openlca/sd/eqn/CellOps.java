package org.openlca.sd.eqn;

import org.openlca.sd.eqn.Cell.NumCell;

class CellOps {

	private CellOps() {
	}

	static Cell add(Cell a, Cell b) {
		if ((a instanceof NumCell(double numA))
			&& (b instanceof NumCell(double numB))) {
			return Cell.of(numA + numB);
		}
		throw EvalException.unsupported("+", a, b);
	}



}
