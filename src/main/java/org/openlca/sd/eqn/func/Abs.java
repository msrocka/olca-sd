package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Abs implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.size() != 1) {
			return Res.error("ABS function requires exactly 1 argument");
		}

		var arg = args.getFirst();
		if (arg == null) {
			return Res.error("ABS function argument cannot be null");
		}

		// absolute value of a number
		if (arg.isNumCell()) {
			double result = Math.abs(arg.asNum());
			return Res.of(Cell.of(result));
		}

		// Absolute value applied element-wise to tensors
		if (arg.isTensorCell())
			return abs(arg.asTensorCell());

		return Res.error("ABS is not defined for cell type: " +
			arg.getClass().getSimpleName());
	}

	private Res<Cell> abs(TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var result = Tensor.of(tensor.dimensions());
		var shape = tensor.shape();
		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);
			var r = apply(List.of(element));
			if (r.hasError()) {
				return r.wrapError("error computing absolute value at index " + i);
			}
			result.set(i, r.value());
		}
		return Res.of(Cell.of(result));
	}

}
