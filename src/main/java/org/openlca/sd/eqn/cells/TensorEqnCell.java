package org.openlca.sd.eqn.cells;

import java.util.stream.Collectors;

import org.openlca.sd.eqn.Tensor;

public record TensorEqnCell(Tensor tensor, String eqn) implements Cell {

	@Override
	public String toString() {
		var dims = tensor.dimensions()
			.stream()
			.map(d -> d.name().label())
			.collect(Collectors.joining(" × "));
		return "tensorEqn{" + dims + ",'" + eqn + "'}";
	}

}