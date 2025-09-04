package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Vars;
import org.openlca.sd.util.TensorPrinter;
import org.openlca.sd.xmile.Xmile;

public class VarsExample {

	public static void main(String[] args) {

		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var vars = Vars.readFrom(xmile).orElseThrow();
		var prt = new TensorPrinter();
		for (var v : vars) {
			System.out.println(v.name() + " :: " + v.name().value());
			prt.print(v.cell());
		}
	}

}
