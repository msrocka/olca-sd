package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openlca.sd.eqn.LookupFunc.Type;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.sd.eqn.cells.EqnCell;
import org.openlca.sd.eqn.cells.LookupEqnCell;
import org.openlca.sd.eqn.cells.NonNegativeCell;
import org.openlca.sd.xmile.XmiAux;
import org.openlca.sd.xmile.XmiDim;
import org.openlca.sd.xmile.XmiEvaluatable;
import org.openlca.sd.xmile.XmiFlow;
import org.openlca.sd.xmile.XmiGf;
import org.openlca.sd.xmile.XmiStock;
import org.openlca.sd.xmile.Xmile;
import org.openlca.util.Res;

public class Vars {

	private Vars() {
	}

	public static Res<List<Var>> readFrom(Xmile xmile) {
		return xmile != null
			? new Reader(xmile).read()
			: Res.error("no Xmile model provided");
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

		Res<List<Var>> read() {
			var model = xmile.model();
			if (model == null)
				return Res.error("no model found");

			var vars = new ArrayList<Var>();
			for (var v : model.variables()) {
				if (!(v instanceof XmiEvaluatable eva))
					continue;
				var cell = cellOf(eva);
				if (cell.hasError())
					return cell.wrapError("failed to create cell for: " + eva.name());

				switch (eva) {
					case XmiAux ignored -> {
						var aux = new Var.Aux(Id.of(eva.name()), cell.value());
						vars.add(aux);
					}
					case XmiFlow ignored -> {
						var flow = new Var.Rate(Id.of(eva.name()), cell.value());
						vars.add(flow);
					}
					case XmiStock s -> {
						var stock = new Var.Stock(
							Id.of(eva.name()),
							cell.value(),
							Id.allOf(s.inflows()),
							Id.allOf(s.outflows()));
						vars.add(stock);
					}
				}
			}
			return Res.of(vars);
		}

		private Res<Cell> cellOf(XmiEvaluatable v) {
			if (v == null)
				return Res.error("variable is null");

			var eqnCell = eqnCellOf(v.eqn(), v.gf(), v.isNonNegative(), null);
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
					elem.isNonNegative() || v.isNonNegative(),
					subs);
				if (cell.hasError())
					return cell.wrapError(
						"invalid array element equation in: " + v.name());

				array.set(subs, cell.value());
			}

			return Res.of(Cell.of(array));
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

		private Res<Cell> eqnCellOf(
			String eqn, XmiGf gf, boolean isNonNegative, List<Subscript> subscripts
		) {
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
				? new LookupEqnCell(eqn, func, subscripts)
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
