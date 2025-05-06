package org.openlca.sd.eqn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openlca.sd.eqn.Cell.TensorCell;

public class Tensor {

	private final Dimension dim;
	private final Cell[] cells;
	private final Dimension[] subs;
	private final int n;

	/// Private copy constructor.
	private Tensor(Dimension dim, Dimension[] subs) {
		this.dim = dim;
		this.subs = subs;
		this.cells = new Cell[dim.size()];
		this.n = 1 + subs.length;
	}

	public Tensor(Dimension dim) {
		this.dim = Objects.requireNonNull(dim);
		this.cells = new Cell[dim.size()];
		this.subs = new Dimension[0];
		this.n = 1;
	}

	public Tensor(List<Dimension> dims) {
		if (dims.isEmpty())
			throw new IllegalArgumentException(
				"Tensor must have at least one dimension");
		this.dim = dims.getFirst();
		this.cells = new Cell[dim.size()];
		this.subs = new Dimension[dims.size() - 1];
		for (int i = 1; i < dims.size(); i++) {
			this.subs[i - 1] = dims.get(i);
		}
		this.n = 1 + subs.length;
	}

	public static Tensor of(Dimension... dims) {
		return new Tensor(Arrays.asList(dims));
	}

	public int dimensions() {
		return 1 + subs.length;
	}

	/// Returns the number of possible elements of this tensor.
	public int size() {
		int s = dim.size();
		for (var sub : subs) {
			s *= sub.size();
		}
		return s;
	}

	public void set(String elem, double value) {
		if (isMatchAll(elem)) {
			setAll(value);
			return;
		}

		int i = dim.indexOf(elem);
		if (i < 0)
			return;
		if (n == 1) {
			cells[i] = Cell.of(value);
			return;
		}
		var sub = cells[i];
		if (sub instanceof TensorCell(Tensor tensor)) {
			tensor.setAll(value);
		} else {
			var tensor = Tensor.of(subs);
			tensor.setAll(value);
			cells[i] = Cell.of(tensor);
		}
	}

	public void set(String row, String col, double value) {
		if (n < 2)
			return;
		if (n == 2) {


		}
	}

	public Cell get(String row) {
		// match-all rows of this tensor, returns a copy of this sensor.
		if (isMatchAll(row))
			return Cell.of(this);


		int i = dim.indexOf(row);
		if (i < 0)
			return Cell.empty();
		var cell = cells[i];
		return cell != null ? cell : Cell.empty();
	}

	public Cell get(String... elements) {
		return get(Arrays.asList(elements));
	}

	public Cell get(List<String> elements) {
		if (elements == null || elements.isEmpty())
			return Cell.empty();
		String first = elements.getFirst();
		var cell = get(first);
		if (elements.size() == 1)
			return cell;
		return cell instanceof TensorCell(Tensor t)
			? t.get(elements.subList(1, elements.size()))
			: Cell.empty();
	}

	public void setAll(double value) {
		if (n == 1) {
			Arrays.fill(cells, Cell.of(value));
			return;
		}
		for (int i = 0; i < cells.length; i++) {
			var c = cells[i];
			if (c instanceof TensorCell(Tensor tensor)) {
				tensor.setAll(value);
			} else {
				var sub = Tensor.of(subs);
				sub.setAll(value);
				cells[i] = Cell.of(sub);
			}
		}
	}

	public Tensor copy() {
		var copy = new Tensor(dim, subs);
		for (int i = 0; i < cells.length; i++) {
			if (cells[i] instanceof TensorCell(Tensor t)) {
				copy.cells[i] = Cell.of(t.copy());
			} else {
				// the other cell types are immutable
				copy.cells[i] = cells[i];
			}
		}
		return copy;
	}

	private boolean isMatchAll(String s) {
		if (s == null)
			return false;
		var ss = s.strip();
		return ss.equals("*") || ss.equals(dim.name());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tensor other))
			return false;

		// compare dimensions
		if (this.n != other.n
			|| !Objects.equals(dim, other.dim))
			return false;
		for (int i = 0; i < subs.length; i++) {
			if (!Objects.equals(subs[i], other.subs[i]))
				return false;
		}

		// compare cells
		for (int i = 0; i < cells.length; i++) {
			if (!Objects.equals(cells[i], other.cells[i]))
				return false;
		}
		return super.equals(obj);
	}
}
