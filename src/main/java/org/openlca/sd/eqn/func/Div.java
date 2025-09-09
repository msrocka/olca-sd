package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.Res;

public class Div implements Func {

	private final Id name = Id.of("DIV");

	public static Res<Cell> apply(Cell a, Cell b) {
		return new Div().apply(List.of(a, b));
	}

	@Override
	public Id name() {
		return name;
	}

	@Override
	public Res<Cell> apply(List<Cell> args) {
		return Fn.withTwoArgs(args, (a, b) -> {

			// division of numbers
			if (a.isNumCell() && b.isNumCell()) {
				double divisor = b.asNum();
				if (divisor == 0.0) {
					return Res.error("division by zero");
				}
				double result = a.asNum() / divisor;
				return Res.of(Cell.of(result));
			}

			// division: tensor ÷ number
			if (a.isTensorCell() && b.isNumCell()) {
				double divisor = b.asNum();
				if (divisor == 0.0) {
					return Res.error("division by zero");
				}
				return scalar(a.asTensorCell(), divisor);
			}

			// division: number ÷ tensor
			if (a.isNumCell() && b.isTensorCell()) {
				return scalar(a.asNum(), b.asTensorCell());
			}

			return Res.error("division is not defined for: " + a + " / " + b);
		});
	}

	private Res<Cell> scalar(TensorCell tensorCell, double divisor) {
		var tensor = tensorCell.value();
		var result = Tensor.of(tensor.dimensions());
		var shape = tensor.shape();
		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);
			var di = apply(List.of(element, Cell.of(divisor)));
			if (di.hasError()) {
				return di.wrapError("error in scalar division at index " + i);
			}
			result.set(i, di.value());
		}
		return Res.of(Cell.of(result));
	}

	private Res<Cell> scalar(double dividend, TensorCell tensorCell) {
		var tensor = tensorCell.value();
		var result = Tensor.of(tensor.dimensions());
		var shape = tensor.shape();
		for (int i = 0; i < shape[0]; i++) {
			var element = tensor.get(i);
			var di = apply(List.of(Cell.of(dividend), element));
			if (di.hasError()) {
				return di.wrapError("error in scalar division at index " + i);
			}
			result.set(i, di.value());
		}
		return Res.of(Cell.of(result));
	}

}
