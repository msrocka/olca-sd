package org.openlca.sd.eqn.cells;

import java.util.Objects;
import java.util.stream.Collectors;

import org.openlca.commons.Res;
import org.openlca.sd.Tensors;
import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.LookupFunc;
import org.openlca.sd.eqn.Tensor;

public record TensorEqnCell(Cell eqn, Tensor tensor) implements Cell {

	public TensorEqnCell {
		Objects.requireNonNull(eqn);
		Objects.requireNonNull(tensor);
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		var res = eqn.eval(interpreter);
		if (res.isError())
			return res;
		var val = res.value();

		if (val instanceof TensorCell(Tensor t))
			return castTensor(t);

		if (!(val instanceof NumCell(double num)))
			return Res.error(
				"Equation does not evaluate to a tensor or number: " + eqn);

		return apply(num, tensor);
	}

	private Res<Cell> castTensor(Tensor result) {
		return Tensors.haveSameDimensions(tensor, result)
			? Res.ok(new TensorCell(result))
			: Res.error("Equation result and tensor definition have " +
			"different dimensions; cast not supported");
	}

	private Res<Cell> apply(double value, Tensor tensor) {
		var t = Tensor.of(tensor.dimensions());
		for (int i = 0; i < tensor().size(); i++) {
			var entry = apply(value, tensor.get(i));
			if (entry.isError())
				return entry;
			t.set(i, entry.value());
		}
		return Res.ok(new TensorCell(t));
	}

	private Res<Cell> apply(double value, Cell cell) {
		return switch (cell) {
			case LookupCell(LookupFunc func) -> apply(value, func);
			case LookupEqnCell(String ignore, LookupFunc func) -> apply(value, func);
			case TensorCell(Tensor t) -> apply(value, t);
			case null, default -> Res.ok(new NumCell(value));
		};
	}

	private Res<Cell> apply(double value, LookupFunc func) {
		double y = func.get(value);
		return Res.ok(new NumCell(y));
	}

	@Override
	public String toString() {
		var dims = tensor.dimensions()
			.stream()
			.map(d -> d.name().label())
			.collect(Collectors.joining(" × "));
		return "tensorEqn{" + dims + ",'" + eqn + "'}";
	}

}
