package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

public class Min implements Func {

	@Override
	public Res<Cell> apply(List<Cell> args) {
		if (args == null || args.isEmpty()) {
			return Res.error("MIN function requires at least one argument");
		}

		// For single argument, check if it's a tensor and find min of all elements
		if (args.size() == 1) {
			var arg = args.get(0);
			if (arg == null) {
				return Res.error("MIN function argument cannot be null");
			}

			if (arg.isNumCell()) {
				return Res.of(arg);
			}

			if (arg.isTensorCell()) {
				return findTensorMin(arg.asTensorCell());
			}

			return Res.error("MIN is not defined for cell type: " +
				arg.getClass().getSimpleName());
		}

		// For multiple arguments, find the minimum among them
		double minValue = Double.POSITIVE_INFINITY;

		for (var arg : args) {
			if (arg == null) {
				return Res.error("MIN function arguments cannot be null");
			}

			if (!arg.isNumCell()) {
				return Res.error("MIN with multiple arguments requires all arguments to be numbers, got: " +
					arg.getClass().getSimpleName());
			}

			double value = arg.asNum();
			if (value < minValue) {
				minValue = value;
			}
		}

		return Res.of(Cell.of(minValue));
	}

	private Res<Cell> findTensorMin(Cell.TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var shape = tensor.shape();
		double minValue = Double.POSITIVE_INFINITY;

		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);

			if (element.isTensorCell()) {
				var subMin = findTensorMin(element.asTensorCell());
				if (subMin.hasError()) {
					return subMin.wrapError("error finding min at index " + i);
				}
				double subValue = subMin.value().asNum();
				if (subValue < minValue) {
					minValue = subValue;
				}
			} else if (element.isNumCell()) {
				double value = element.asNum();
				if (value < minValue) {
					minValue = value;
				}
			} else {
				return Res.error("MIN requires numeric elements in tensor, got: " +
					element.getClass().getSimpleName() + " at index " + i);
			}
		}

		return Res.of(Cell.of(minValue));
	}

}
