package org.openlca.sd.eqn;

import java.util.function.DoubleBinaryOperator;

import org.openlca.sd.eqn.Cell.NumCell;
import org.openlca.sd.util.Res;

class CellOps {

	private CellOps() {
	}

	static Res<Cell> add(Cell a, Cell b) {
		return numeric("+", a, b, Double::sum);
	}

	static Res<Cell> sub(Cell a, Cell b) {
		return numeric("-", a, b, (x, y) -> x - y);
	}

	static Res<Cell> mod(Cell a, Cell b) {
		return numeric("%", a, b, (x, y) -> {
			if (y != 0)
				return x % y;
			return Double.NaN; // Will be caught as error
		});
	}

	static Res<Cell> mul(Cell a, Cell b) {
		return numeric("*", a, b, (x, y) -> x * y);
	}

	static Res<Cell> div(Cell a, Cell b) {
		return numeric("/", a, b, (x, y) -> {
			if (y != 0)
				return x / y;
			return Double.NaN; // Will be caught as error
		});
	}

	static Res<Cell> pow(Cell a, Cell b) {
		return numeric("^", a, b, Math::pow);
	}

	private static Res<Cell> numeric(
		String op, Cell a, Cell b, DoubleBinaryOperator fn
	) {
		if ((a instanceof NumCell(double numA))
			&& (b instanceof NumCell(double numB))) {

			// Handle division by zero for modulo and division
			if ((op.equals("%") || op.equals("/")) && numB == 0.0) {
				return Res.error("division by zero");
			}

			double result = fn.applyAsDouble(numA, numB);
			return Res.of(Cell.of(result));
		}
		return Res.error("operation " + op + " is not supported for cell types: " +
			a.getClass().getSimpleName() + " and " + b.getClass().getSimpleName());
	}
}
