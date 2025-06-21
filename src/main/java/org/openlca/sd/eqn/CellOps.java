package org.openlca.sd.eqn;

import java.util.function.DoubleBinaryOperator;

import org.openlca.sd.eqn.Cell.NumCell;

class CellOps {

	private CellOps() {
	}

	static Cell add(Cell a, Cell b) {
		return numeric("+", a, b, Double::sum);
	}

	static Cell sub(Cell a, Cell b) {
		return numeric("-", a, b, (x, y) -> x - y);
	}

	static Cell mod(Cell a, Cell b) {
		return numeric("%", a, b, (x, y) -> {
			if (y != 0)
				return x % y;
			throw EvalException.of("division by 0");
		});
	}

	static Cell mul(Cell a, Cell b) {
		return numeric("*", a, b, (x, y) -> x * y);
	}

	static Cell div(Cell a, Cell b) {
		return numeric("/", a, b, (x, y) -> {
			if (y != 0)
				return x / y;
			throw EvalException.of("division by 0");
		});
	}

	static Cell pow(Cell a, Cell b) {
		return numeric("^", a, b, Math::pow);
	}

	private static Cell numeric(
		String op, Cell a, Cell b, DoubleBinaryOperator fn
	) {
		if ((a instanceof NumCell(double numA))
			&& (b instanceof NumCell(double numB))) {
			return Cell.of(fn.applyAsDouble(numA, numB));
		}
		throw EvalException.unsupported(op, a, b);
	}


}
