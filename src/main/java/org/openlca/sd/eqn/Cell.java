package org.openlca.sd.eqn;

/// The possible types of a tensor cell entry.
public sealed interface Cell {

	static Cell of(Tensor tensor) {
		return tensor != null
			? new TensorCell(tensor)
			: empty();
	}

	static Cell of(double number) {
		return new NumCell(number);
	}

	static Cell of(boolean b) {
		return new BoolCell(b);
	}

	static Cell of(String eqn) {
		return Util.isEmpty(eqn)
			? new EqnCell(eqn)
			: empty();
	}

	static Cell empty() {
		return EmptyCell.get();
	}

	default boolean isEmpty() {
		return switch (this) {
			case EmptyCell ignored -> true;
			case NumCell ignored -> false;
			case BoolCell ignored -> false;
			case TensorCell(Tensor tensor) -> tensor != null;
			case EqnCell(String eqn) -> eqn != null && !eqn.isBlank();
		};
	}

	default boolean isTensorCell() {
		return this instanceof TensorCell;
	}

	default boolean isNumCell() {
		return this instanceof NumCell;
	}

	default boolean isBoolCell() {
		return this instanceof BoolCell;
	}

	default boolean isEqnCell() {
		return this instanceof EqnCell;
	}

	default TensorCell asTensorCell() {
		if (this instanceof TensorCell cell)
			return cell;
		throw new IllegalStateException("is not a TensorCell");
	}

	default NumCell asNumCell() {
		if (this instanceof NumCell cell)
			return cell;
		throw new IllegalStateException("is not a NumCell");
	}

	default BoolCell asBoolCell() {
		if (this instanceof BoolCell cell)
			return cell;
		throw new IllegalStateException("is not a NumCell");
	}

	default EqnCell asEqnCell() {
		if (this instanceof EqnCell cell)
			return cell;
		throw new IllegalStateException("is not a EqnCell");
	}

	record EmptyCell() implements Cell {
		private static final EmptyCell _instance = new EmptyCell();

		private static EmptyCell get() {
			return _instance;
		}

		@Override
		public boolean equals(Object other) {
			return other == this
				|| other instanceof Cell cell && cell.isEmpty();
		}

	}

	record TensorCell(Tensor value) implements Cell {
	}

	record NumCell(double value) implements Cell {

		@Override
		public String toString() {
			return Double.toString(value);
		}
	}

	record BoolCell(boolean value) implements Cell {

		@Override
		public String toString() {
			return Boolean.toString(value);
		}
	}

	record EqnCell(String value) implements Cell {

		@Override
		public String toString() {
			return value;
		}
	}
}
