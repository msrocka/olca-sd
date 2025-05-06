package org.openlca.sd.eqns;

/// The possible types of a tensor cell entry.
public sealed interface Cell {

	static Cell of(Tensor tensor) {
		return tensor != null
			? new TensorCell(tensor)
			: new EmptyCell();
	}

	static Cell of(double number) {
		return new NumberCell(number);
	}

	static Cell of(String eqn) {
		return eqn != null && !eqn.isBlank()
			? new EqnCell(eqn)
			: new EmptyCell();
	}

	default boolean isEmpty() {
		return switch (this) {
			case EmptyCell ignored -> true;
			case NumberCell ignored -> false;
			case TensorCell(Tensor tensor) -> tensor != null;
			case EqnCell(String eqn) -> eqn != null && !eqn.isBlank();
		};
	}

	default boolean isTensorCell() {
		return this instanceof TensorCell;
	}

	default boolean isNumberCell() {
		return this instanceof NumberCell;
	}

	default boolean isEqnCell() {
		return this instanceof EqnCell;
	}

	default TensorCell getAsTensorCell() {
		if (this instanceof TensorCell cell)
			return cell;
		throw new IllegalStateException("is not a TensorCell");
	}

	default NumberCell getAsNumberCell() {
		if (this instanceof NumberCell cell)
			return cell;
		throw new IllegalStateException("is not a NumberCell");
	}

	default EqnCell getAsEqnCell() {
		if (this instanceof EqnCell cell)
			return cell;
		throw new IllegalStateException("is not a EqnCell");
	}

	record EmptyCell() implements Cell {
	}

	record TensorCell(Tensor tensor) implements Cell {
	}

	record NumberCell(double number) implements Cell {
	}

	record EqnCell(String eqn) implements Cell {
	}
}
