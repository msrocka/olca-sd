package org.openlca.sd.eqn.func;

import java.util.Arrays;
import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Mul implements Func {

	private final Id name = Id.of("MUL");

	public static Res<Cell> apply(Cell a, Cell b) {
		return new Mul().apply(List.of(a, b));
	}

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withTwoArgs(args, (a, b) -> {

			// multiplication of numbers
			if (a.isNumCell() && b.isNumCell()) {
				double result = a.asNum() * b.asNum();
				return Res.of(Cell.of(result));
			}

			// scalar multiplication
			if (a.isNumCell() && b.isTensorCell())
				return scalar(a.asNum(), b.asTensorCell());
			if (a.isTensorCell() && b.isNumCell())
				return scalar(b.asNum(), a.asTensorCell());

			// element-wise multiplication for tensor * tensor
			if (a.isTensorCell() && b.isTensorCell())
				return elemWise(a.asTensorCell(), b.asTensorCell());

			return Res.error("multiplication is not defined for: " + a + " * " + b);
		});
	}

	private Res<Cell> scalar(double s, TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var result = Tensor.of(tensor.dimensions());
		for (int i = 0; i < tensor.size(); i++) {
			var ai = tensor.get(i);
			var ri = apply(List.of(Cell.of(s), ai));
			if (ri.hasError())
				return ri.wrapError("error in scalar multiplication at index " + i);
			result.set(i, ri.value());
		}
		return Res.of(Cell.of(result));
	}

	private Res<Cell> elemWise(TensorCell cellA, TensorCell cellB) {
		var a = cellA.value();
		var b = cellB.value();
		var shapeA = a.shape();
		var shapeB = b.shape();

		if (!Arrays.equals(shapeA, shapeB)) {
			return Res.error("element-wise multiplication requires same shapes: " +
				Arrays.toString(shapeA) + " vs " + Arrays.toString(shapeB));
		}

		var result = Tensor.of(a.dimensions());
		for (int i = 0; i < shapeA[0]; i++) {
			var ai = a.get(i);
			var bi = b.get(i);
			var ci = apply(List.of(ai, bi));
			if (ci.hasError()) {
				return ci.wrapError(
					"error in element-wise multiplication at index " + i);
			}
			result.set(i, ci.value());
		}
		return Res.of(Cell.of(result));
	}

}
