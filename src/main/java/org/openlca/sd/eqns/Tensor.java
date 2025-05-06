package org.openlca.sd.eqns;

import java.util.List;
import java.util.Objects;

public class Tensor {

	private final Dimension dim;
	private final Cell[] cells;
	private final Dimension[] subs;

	public Tensor(Dimension dim) {
		this.dim = Objects.requireNonNull(dim);
		this.cells = new Cell[dim.size()];
		this.subs = new Dimension[0];
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
	}

	public int dimensions() {
		return 1 + subs.length;
	}

}
