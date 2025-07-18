package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openlca.sd.util.Res;
import org.openlca.sd.xmile.XmiAux;
import org.openlca.sd.xmile.XmiDim;
import org.openlca.sd.xmile.XmiEvaluatable;
import org.openlca.sd.xmile.XmiFlow;
import org.openlca.sd.xmile.XmiGf;
import org.openlca.sd.xmile.XmiStock;
import org.openlca.sd.xmile.Xmile;

public class Graph {

	private final Map<Id, Node> nodes = new HashMap<>();
	private final Map<Id, Id> edges = new HashMap<>();

	public record Node(Var var, List<Cell> values) {
	}

	public static Graph readFrom(Xmile xmile) {
		return xmile != null
			? new Reader(xmile).read()
			: new Graph();
	}



	private static class Reader {

		private final Xmile xmile;
		private final HashMap<Id, Dimension> dimensions;

		Reader(Xmile xmile) {
			this.xmile = xmile;
			dimensions = new HashMap<>();
			for (var d : xmile.dims()) {
				var dim = dimOf(d);
				dimensions.put(dim.name(), dim);
			}
		}

		private Dimension dimOf(XmiDim d) {
			var id = Id.of(d.name());
			int n = d.elems().size();
			var elements = new Id[n];
			for (int i = 0; i < d.elems().size(); i++) {
				var elem = d.elems().get(i);
				elements[i] = Id.of(elem.name());
			}
			return new Dimension(id, elements);
		}

		Graph read() {
			var g = new Graph();
			var model = xmile.model();
			if (model == null)
				return g;

			for (var v : model.variables()) {
				switch (v) {
					case XmiAux aux -> {}
					case XmiFlow flow -> {}
					case XmiStock stock -> {}
					case XmiGf gf -> {}
				}
			}
			return g;
		}

		private Node auxNodeOf(XmiAux aux) {


			return null;
		}

		private Res<Cell> cellOf(XmiEvaluatable v) {
			if (v == null)
				return Res.error("variable is null");

			if (!v.dimensions().isEmpty()) {
				var dims = dimsOf(v);
				if (dims.hasError())
					return dims.wrapError("could not read dimensions of: " + v);
				var array = Tensor.of(dims.value());



			}

			return Res.error("not yet implemented");
		}


		private Res<List<Dimension>> dimsOf(XmiEvaluatable v) {
			var dims = new ArrayList<Dimension>();
			for (var d : v.dimensions()) {
				var dim = dimensions.get(Id.of(d.name()));
				if (dim == null)
					return Res.error("unknown dimension: " + d.name());
				dims.add(dim);
			}
			return Res.of(dims);
		}

	}
}
