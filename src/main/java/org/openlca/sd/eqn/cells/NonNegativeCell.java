package org.openlca.sd.eqn.cells;

import java.util.List;
import java.util.Objects;

import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.func.Abs;
import org.openlca.util.Res;

public record NonNegativeCell(Cell value) implements Cell {

	public NonNegativeCell {
		Objects.requireNonNull(value);
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		var res = value.eval(interpreter);
		return res.hasError()
			? res
			: new Abs().apply(List.of(res.value()));
	}

	@Override
	public String toString() {
		return "nonNeg{" + value + "}";
	}

}
