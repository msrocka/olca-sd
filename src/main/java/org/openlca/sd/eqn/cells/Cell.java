package org.openlca.sd.eqn.cells;

import java.util.List;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.LookupFunc;
import org.openlca.sd.eqn.Subscript;
import org.openlca.sd.eqn.Tensor;
import org.openlca.util.Res;

/// The possible types of a tensor cell entry.
public sealed interface Cell permits
	EmptyCell,
	TensorCell,
	NumCell,
	BoolCell,
	EqnCell,
	LookupCell,
	LookupEqnCell,
	TensorEqnCell,
	NonNegativeCell {

	Res<Cell> eval(Interpreter interpreter);

	static Cell of(Tensor tensor) {
		return tensor != null
			? new TensorCell(tensor)
			: empty();
	}

	static Cell of(boolean b) {
		return new BoolCell(b);
	}

	static Cell of(String eqn) {
		return Id.isNil(eqn) ? Cell.empty() : new EqnCell(eqn);
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
			case EqnCell(String eqn) -> Id.isNil(eqn);
			case LookupEqnCell(String eqn, LookupFunc func, List<Subscript> ignore) ->
				Id.isNil(eqn) || func == null;
			case NonNegativeCell(Cell value) -> value == null;
			case TensorEqnCell(Tensor tensor, String eqn) ->
				tensor == null || Id.isNil(eqn);
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

	default double asNum() {
		return asNumCell().value();
	}

	default BoolCell asBoolCell() {
		if (this instanceof BoolCell cell)
			return cell;
		throw new IllegalStateException("is not a NumCell");
	}

	default boolean asBool() {
		return asBoolCell().value();
	}

	default EqnCell asEqnCell() {
		if (this instanceof EqnCell cell)
			return cell;
		throw new IllegalStateException("is not a EqnCell");
	}
}
