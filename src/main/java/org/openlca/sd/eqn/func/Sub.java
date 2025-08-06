package org.openlca.sd.eqn.func;

import java.util.Arrays;
import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Sub implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withTwoArgs(args, (a, b) -> {

			if (a.isNumCell() && b.isNumCell()) {
				double result = a.asNum() - b.asNum();
				return Res.of(Cell.of(result));
			}

			if (a.isTensorCell() && b.isTensorCell())
				return sub(a.asTensorCell(), b.asTensorCell());

			return Res.error("subtraction is not defined for cell types: " +
				a.getClass().getSimpleName() + " and " +
				b.getClass().getSimpleName());
		});
	}

	private Res<Cell> sub(TensorCell cellA, TensorCell cellB) {
		var a = cellA.value();
		var b = cellB.value();

		var shapeA = a.shape();
		var shapeB = b.shape();

		if (!Arrays.equals(shapeA, shapeB)) {
			return Res.error("cannot subtract tensors with different shapes: " +
				Arrays.toString(shapeA) + " vs " + Arrays.toString(shapeB));
		}

		var diff = Tensor.of(a.dimensions());

		for (int i = 0; i < shapeA[0]; i++) {
			var ai = a.get(i);
			var bi = b.get(i);
			var di = apply(List.of(ai, bi));
			if (di.hasError())
				return di.wrapError("error subtracting tensor elements at index " + i);
			diff.set(i, di.value());
		}
		return Res.of(Cell.of(diff));
	}

}
