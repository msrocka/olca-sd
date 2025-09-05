package org.openlca.sd;

import java.io.File;
import java.util.HashSet;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Var.Stock;
import org.openlca.sd.eqn.Vars;
import org.openlca.sd.xmile.Xmile;

public class VarsCheck {

	public static void main(String[] args) {

		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var vars = Vars.readFrom(xmile).orElseThrow();

		var ids = new HashSet<Id>();
		for (var v : vars) {
			ids.add(v.name());
		}

		// check that used vars are defined
		int undef = 0;
		for (var v : vars) {
			for (var dep : v.dependencies()) {
				if (!ids.contains(dep)) {
					System.out.println("use of undefined var: " + dep);
					undef++;
				}
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
