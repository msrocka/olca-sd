package org.openlca.sd.eqn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.openlca.sd.eqn.Cell.NumCell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Subscript.Empty;
import org.openlca.sd.eqn.Subscript.Identifier;
import org.openlca.sd.eqn.Subscript.Index;
import org.openlca.sd.eqn.Subscript.Wildcard;

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
		return n;
	}

	public Dimension dimension() {
		return dim;
	}

	/// Returns the number of possible elements of this tensor.
	public int size() {
		int s = dim.size();
		for (var sub : subs) {
			s *= sub.size();
		}
		return s;
	}

	public void set(Subscript idx, Cell cell) {
		if (idx == null)
			return;
		switch (idx) {
			case Empty $ -> {}
			case Wildcard $ -> setAll(cell);
			case Index(int i) -> set(i, cell);
			case Identifier(String id) -> {
				if (id.equals(dim.name())) {
					setAll(cell);
				} else {
					set(dim.indexOf(id), cell);
				}
			}
		}
	}

	public void set(int index, Cell cell) {
		if (index < 0 || index >= dim.size())
			return;
		if (n == 1) {
			cells[index] = cell;
			return;
		}
		withTensorAt(index, tensor -> tensor.setAll(cell));
	}

	public void set(List<Subscript> ixs, Cell cell) {
		if (ixs == null || ixs.isEmpty())
			return;

		var idx = ixs.getFirst();
		if (ixs.size() == 1 || n == 1) {
			set(idx, cell);
			return;
		}

		switch (idx) {
			case Index(int i) -> withTensorAt(i,
				tensor -> tensor.set(ixs.subList(1, ixs.size()), cell));

		}


	}


	private void withTensorAt(int idx, Consumer<Tensor> fn) {
		if (idx < 0 || idx >= cells.length)
			return;
		var cell = cells[idx];
		if (cell instanceof TensorCell(Tensor tensor)) {
			fn.accept(tensor);
		} else {
			var tensor = Tensor.of(subs);
			cells[idx] = Cell.of(tensor);
			fn.accept(tensor);
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

	public void setAll(Cell cell) {
		if (cell == null) {
			setAll(Cell.empty());
			return;
		}
		if (n == 1) {
			Arrays.fill(cells, cell);
			return;
		}
		for (int i = 0; i < cells.length; i++) {
			var c = cells[i];
			if (c instanceof TensorCell(Tensor tensor)) {
				tensor.setAll(cell);
			} else {
				var sub = Tensor.of(subs);
				sub.setAll(cell);
				cells[i] = Cell.of(sub);
			}
		}

	}

	public void setAll(double value) {
		setAll(new NumCell(value));
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
