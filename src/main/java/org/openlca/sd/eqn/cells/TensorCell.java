package org.openlca.sd.eqn.cells;

import java.util.stream.Collectors;

import org.openlca.sd.eqn.Tensor;

public record TensorCell(Tensor value) implements Cell {

	@Override
	public String toString() {
		if (value == null)
			return "tensor{}";
		var dims = value.dimensions()
			.stream()
			.map(d -> d.name().label())
			.collect(Collectors.joining(" × "));
		return "tensor{" + dims + "}";
	}

}