package org.openlca.sd.eqn.cells;

import java.util.Objects;
import java.util.stream.Collectors;

import org.openlca.sd.Tensors;
import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.Tensor;
import org.openlca.util.Res;

public record TensorEqnCell(Cell eqn, Tensor tensor) implements Cell {

	public TensorEqnCell {
		Objects.requireNonNull(eqn);
		Objects.requireNonNull(tensor);
	}

	@Override
	public Res<Cell> eval(Interpreter interpreter) {
		var res = eqn.eval(interpreter);
		if (res.hasError())
			return res;
		var val = res.value();

		if (val instanceof TensorCell(Tensor t))
			return castTensor(t);



		return null;
	}

	private Res<Cell> castTensor(Tensor result) {
		return Tensors.haveSameDimensions(tensor, result)
			? Res.of(new TensorCell(result))
			: Res.error("Equation result and tensor definition have " +
			"different dimensions; cast not supported");
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
