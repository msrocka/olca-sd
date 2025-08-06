package org.openlca.sd.eqn.func;

import java.util.Arrays;
import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Mul implements Func {

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

			// matrix/vector multiplication:
			if (a.isTensorCell() && b.isTensorCell())
				return matrixMul(a.asTensorCell(), b.asTensorCell());

			return Res.error("multiplication is not defined for cell types: " +
				a.getClass().getSimpleName() + " and " +
				b.getClass().getSimpleName());
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

	private Res<Cell> matrixMul(TensorCell cellA, TensorCell cellB) {
		var a = cellA.value();
		var b = cellB.value();
		var shapeA = a.shape();
		var shapeB = b.shape();

		// For matrix multiplication, we need compatible dimensions
		// A(m×n) × B(n×p) = C(m×p)
		// The inner dimensions must match: shapeA[1] == shapeB[0]

		if (shapeA.length == 1 && shapeB.length == 1) {
			// Vector dot product: both are 1D vectors of same length
			if (shapeA[0] != shapeB[0]) {
				return Res.error("cannot multiply vectors with different lengths: " +
					shapeA[0] + " vs " + shapeB[0]);
			}
			return dot(a, b);
		}

		if (shapeA.length == 2 && shapeB.length == 1) {
			// Matrix × vector: A(m×n) × B(n) = C(m)
			if (shapeA[1] != shapeB[0]) {
				return Res.error("cannot multiply matrix(" + shapeA[0] + "×" + shapeA[1] +
					") with vector(" + shapeB[0] + "): inner dimensions don't match");
			}
			return mv(a, b);
		}

		if (shapeA.length == 2 && shapeB.length == 2) {
			// Matrix × matrix: A(m×n) × B(n×p) = C(m×p)
			if (shapeA[1] != shapeB[0]) {
				return Res.error("cannot multiply matrices with incompatible dimensions: " +
					"(" + shapeA[0] + "×" + shapeA[1] + ") × (" + shapeB[0] + "×" + shapeB[1] + ")");
			}
			return mm(a, b);
		}

		// For higher dimensions or other cases, fall back to element-wise multiplication
		// (this requires same shapes like addition)
		if (!Arrays.equals(shapeA, shapeB)) {
			return Res.error("element-wise multiplication requires same shapes: " +
				Arrays.toString(shapeA) + " vs " + Arrays.toString(shapeB));
		}
		return elemWise(a, b);
	}

	private Res<Cell> dot(Tensor a, Tensor b) {
		double sum = 0.0;
		var shape = a.shape();
		for (int i = 0; i < shape[0]; i++) {
			var ai = a.get(i);
			var bi = b.get(i);
			if (!ai.isNumCell() || !bi.isNumCell())
				return Res.error("vector dot product requires numeric elements");
			sum += ai.asNum() * bi.asNum();
		}
		return Res.of(Cell.of(sum));
	}

	private Res<Cell> mv(Tensor m, Tensor v) {
		var matrixShape = m.shape();
		var result = new Tensor(m.dimensions().getFirst());
		for (int i = 0; i < matrixShape[0]; i++) {
			var row = m.get(i);
			if (!row.isTensorCell())
				return Res.error("matrix row is not a tensor at index " + i);
			var dot = dot(row.asTensorCell().value(), v);
			if (dot.hasError())
				return dot.wrapError("error in matrix-vector multiplication at row " + i);
			result.set(i, dot.value());
		}
		return Res.of(Cell.of(result));
	}

	private Res<Cell> mm(Tensor a, Tensor b) {
		var shapeA = a.shape();
		var shapeB = b.shape();
		var result = Tensor.of(
			List.of(a.dimensions().getFirst(), b.dimensions().get(1)));

		for (int i = 0; i < shapeA[0]; i++) {
			var rowA = a.get(i);
			if (!rowA.isTensorCell())
				return Res.error("row " + i + " of matrix A is not a tensor");
			var ai = rowA.asTensorCell().value();

			for (int j = 0; j < shapeB[1]; j++) {
				var colB = columnOf(b, j);
				if (colB.hasError())
					return colB.wrapError("failed to get column " + j + " of matrix B");
				var cij = dot(ai, colB.value());
				if (cij.hasError())
					return cij.wrapError(
						"failed to multiply row " + i + " with column " + j);
				result.get(i).asTensorCell().value().set(j, cij.value());
			}
		}
		return Res.of(Cell.of(result));
	}

	private Res<Tensor> columnOf(Tensor matrix, int j) {
		var shape = matrix.shape();
		var col = new Tensor(matrix.dimensions().getFirst());
		for (int i = 0; i < shape[0]; i++) {
			var row = matrix.get(i);
			if (!row.isTensorCell())
				return Res.error("matrix row is not a tensor at index " + i);
			var element = row.asTensorCell().value().get(j);
			col.set(i, element);
		}
		return Res.of(col);
	}

	private Res<Cell> elemWise(Tensor a, Tensor b) {
		var result = Tensor.of(a.dimensions());
		var shape = a.shape();
		for (int i = 0; i < shape[0]; i++) {
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
