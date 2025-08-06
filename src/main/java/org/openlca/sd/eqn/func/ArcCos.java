package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class ArcCos implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withOneArg(args, arg -> {

			// Arccosine of a number
			if (arg.isNumCell()) {
				double value = arg.asNum();
				if (value < -1.0 || value > 1.0) {
					return Res.error("ARCCOS domain error: input must be in range [-1, 1], got " + value);
				}
				double result = Math.acos(value);
				return Res.of(Cell.of(result));
			}

			// Arccosine applied element-wise to tensors
			if (arg.isTensorCell()) {
				return tensorArcCos(arg.asTensorCell());
			}

			return Res.error("ARCCOS is not defined for cell type: " +
				arg.getClass().getSimpleName());
		});
	}

	private Res<Cell> tensorArcCos(TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var result = Tensor.of(tensor.dimensions());
		var shape = tensor.shape();
		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);
			var ri = apply(List.of(element));
			if (ri.hasError())
				return ri.wrapError("error computing arccosine at index " + i);
			result.set(i, ri.value());
		}
		return Res.of(Cell.of(result));
	}

}
