package org.openlca.sd;

import java.io.File;
import java.util.HashSet;

import org.openlca.sd.eqn.Cell.EqnCell;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Interpreter;
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
		}
		System.out.println(undef + " uses of undefined vars");

	}

}
