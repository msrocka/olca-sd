package org.openlca.sd.eqn.func;

import java.util.Arrays;
import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Add implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.with2Args(args, (a, b) -> {

			if (a.isNumCell() && b.isNumCell()) {
				double result = a.asNum() + b.asNum();
				return Res.of(Cell.of(result));
			}

			if (a.isTensorCell() && b.isTensorCell())
				return add(a.asTensorCell(), b.asTensorCell());

			return Res.error("addition is not defined for cell types: " +
				a.getClass().getSimpleName() + " and " +
				b.getClass().getSimpleName());
		});
	}

	private Res<Cell> add(TensorCell cellA, TensorCell cellB) {
		var a = cellA.value();
		var b = cellB.value();

		var shapeA = a.shape();
		var shapeB = b.shape();

		if (!Arrays.equals(shapeA, shapeB)) {
			return Res.error("cannot add tensors with different shapes: " +
				Arrays.toString(shapeA) + " vs " + Arrays.toString(shapeB));
		}

		var sum = Tensor.of(a.dimensions());

		for (int i = 0; i < shapeA[0]; i++) {
			var ai = a.get(i);
			var bi = b.get(i);
			var si = apply(List.of(ai, bi));
			if (si.hasError())
				return si.wrapError("error adding tensor elements at index " + i);
			sum.set(i, si.value());
		}
		return Res.of(Cell.of(sum));
	}

}
