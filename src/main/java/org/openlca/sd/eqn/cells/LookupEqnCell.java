package org.openlca.sd.eqn.cells;

import java.util.Objects;

import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.LookupFunc;
import org.openlca.util.Res;

/// A cell with a lookup function and an equation where the equation
/// evaluates to a value that is then passed into the lookup function.
public record LookupEqnCell(
	String eqn, LookupFunc func
) implements Cell {

	public LookupEqnCell {
		Objects.requireNonNull(eqn);
		Objects.requireNonNull(func);
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		var res = interpreter.eval(eqn);
		if (res.hasError())
			return res;
		if ((!(res.value() instanceof NumCell(double value)))) {
			return Res.error(
				"equation of lookup cell does not evaluate to a number:" + eqn);
		}
		double result = func.get(value);
		return Res.of(new NumCell(result));
	}

	@Override
	public String toString() {
		return "lookup{'" + eqn + "'}";
	}
}
