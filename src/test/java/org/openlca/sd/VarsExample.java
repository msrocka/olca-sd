package org.openlca.sd;

import java.io.File;
import java.util.HashSet;

import org.openlca.sd.eqn.Cell.EqnCell;
import org.openlca.sd.eqn.Cell.TensorCell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Interpreter;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.eqn.Var.Stock;
import org.openlca.sd.eqn.Vars;
import org.openlca.sd.util.TensorPrinter;
import org.openlca.sd.xmile.Xmile;

public class VarsExample {

	public static void main(String[] args) {

		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var vars = Vars.readFrom(xmile).orElseThrow();
		var prt = new TensorPrinter();

		var ids = new HashSet<Id>();
		for (var v : vars) {
			ids.add(v.name());
		}

		// check that used vars are defined
		int undef = 0;
		for (var v : vars) {
			if (v.cell() instanceof EqnCell(String eqn)) {
				var used = Interpreter.varsOf(eqn).orElseThrow();
				for (var u : used) {
					if (!ids.contains(u) && !u.equals(Id.of("TIME"))) {
						System.out.println("use of undefined var: " + u);
						undef++;
					}
				}
			}

			if (v.cell() instanceof TensorCell(Tensor t)) {

			}

		}
		System.out.println(undef + " uses of undefined vars");

		int stockCount = 0;
		for (var v : vars) {
			if (!(v instanceof Stock stock))
				continue;
			stockCount++;
			if (stock.inFlows().isEmpty() && stock.outFlows().isEmpty()) {
				System.out.println("unlinked stock: " + stock.name());
				continue;
			}
			for (var in : stock.inFlows()) {
				if (!ids.contains(in)) {
					System.out.println(
						"unknown var linked from stock: "  + in + " @" + stock.name());
				}
			}

			for (var out : stock.outFlows()) {
				if (!ids.contains(out)) {
					System.out.println(
						"unknown var linked from stock: "  + out + " @" + stock.name());
				}
			}

		}
		System.out.println("checked " + stockCount + " stocks");

	}

}
