package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openlca.sd.eqn.Cell.EqnCell;
import org.openlca.sd.eqn.Cell.LookupCell;
import org.openlca.sd.eqn.Cell.NonNegativeCell;
import org.openlca.sd.eqn.LookupFunc.Type;
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
					case XmiAux aux -> {
					}
					case XmiFlow flow -> {
					}
					case XmiStock stock -> {
					}
					case XmiGf gf -> {
					}
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

			var eqnCell = eqnCellOf(v.eqn(), v.gf(), v.isNonNegative());
			if (v.dimensions().isEmpty() || eqnCell.hasError())
				return eqnCell;

			var dims = dimsOf(v);
			if (dims.hasError())
				return dims.wrapError("could not read dimensions of: " + v);

			// create the array and initialize it with the outer equation by default
			var array = Tensor.of(dims.value());
			array.setAll(eqnCell.value());
			if (v.elements().isEmpty())
				return Res.of(Cell.of(array));

			for (var elem : v.elements()) {
				var subs = Subscript.parseAllFrom(elem.subscript());
				if (subs.isEmpty())
					return Res.error(
						"array elements defined without subscripts in: " + v.name());

				var cell = eqnCellOf(
					Id.isNil(elem.eqn()) ? v.eqn() : elem.eqn(),
					elem.gf(),
					elem.isNonNegative() || v.isNonNegative());
				if (cell.hasError())
					return cell.wrapError(
						"invalid array element equation in: " + v.name());

				array.set(subs, cell.value());
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

		private Res<Cell> eqnCellOf(String eqn, XmiGf gf, boolean isNonNegative) {
			if (Id.isNil(eqn))
				return Res.of(Cell.empty());

			LookupFunc func = null;
			if (gf != null) {
				var funcRes = funcOf(gf);
				if (funcRes.hasError())
					return funcRes.wrapError("invalid lookup function");
				func = funcRes.value();
			}

			var cell = func != null
				? new LookupCell(eqn, func)
				: new EqnCell(eqn);

			return isNonNegative
				? Res.of(new NonNegativeCell(cell))
				: Res.of(cell);
		}

		private Res<LookupFunc> funcOf(XmiGf gf) {
			if (gf == null)
				return Res.error("no lookup function defined");

			var type = switch (gf.type()) {
				case CONTINUOUS -> Type.CONTINUOUS;
				case DISCRETE -> Type.DISCRETE;
				case null, default -> Type.EXTRAPOLATE;
			};

			if (gf.ypts() == null)
				return Res.error("y-values not provided in lookup function");
			var ys = gf.ypts().parse();

			if (gf.xpts() != null)
				return Res.of(new LookupFunc(type, gf.xpts().parse(), ys));

			if (gf.xscale() != null) {
				var min = gf.xscale().min();
				var max = gf.xscale().max();
				return Res.of(new LookupFunc(type, min, max, ys));
			}

			return Res.error("no x-values defined in lookup function");
		}
	}
}
