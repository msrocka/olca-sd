package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

public class Max implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.isEmpty()) {
			return Res.error("MAX function requires at least one argument");
		}

		// For single argument, check if it's a tensor and find max of all elements
		if (args.size() == 1) {
			var arg = args.get(0);
			if (arg == null) {
				return Res.error("MAX function argument cannot be null");
			}

			if (arg.isNumCell()) {
				return Res.of(arg);
			}

			if (arg.isTensorCell()) {
				return findTensorMax(arg.asTensorCell());
			}

			return Res.error("MAX is not defined for cell type: " +
				arg.getClass().getSimpleName());
		}

		// For multiple arguments, find the maximum among them
		double maxValue = Double.NEGATIVE_INFINITY;

		for (var arg : args) {
			if (arg == null) {
				return Res.error("MAX function arguments cannot be null");
			}

			if (!arg.isNumCell()) {
				return Res.error("MAX with multiple arguments requires all arguments to be numbers, got: " +
					arg.getClass().getSimpleName());
			}

			double value = arg.asNum();
			if (value > maxValue) {
				maxValue = value;
			}
		}

		return Res.of(Cell.of(maxValue));
	}

	private Res<Cell> findTensorMax(Cell.TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var shape = tensor.shape();
		double maxValue = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);

			if (element.isTensorCell()) {
				var subMax = findTensorMax(element.asTensorCell());
				if (subMax.hasError()) {
					return subMax.wrapError("error finding max at index " + i);
				}
				double subValue = subMax.value().asNum();
				if (subValue > maxValue) {
					maxValue = subValue;
				}
			} else if (element.isNumCell()) {
				double value = element.asNum();
				if (value > maxValue) {
					maxValue = value;
				}
			} else {
				return Res.error("MAX requires numeric elements in tensor, got: " +
					element.getClass().getSimpleName() + " at index " + i);
			}
		}

		return Res.of(Cell.of(maxValue));
	}

}
