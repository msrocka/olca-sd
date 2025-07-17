package org.openlca.sd;

import java.io.File;

import org.openlca.sd.xmile.XmiAux;
import org.openlca.sd.xmile.XmiGf;
import org.openlca.sd.xmile.Xmile;

public class GraphExample {

	public static void main(String[] args) {

		var xmile = Xmile.readFrom(new File("examples/generic-plastic-case.xml"));
		var model = xmile.model();
		boolean used = false;
		for (var v : model.variables()) {
			if (v instanceof XmiGf gf) {
				System.out.println(gf.name());
			}
			if (v instanceof XmiAux aux) {
				if (!aux.elements().isEmpty()) {
					used = true;
					System.out.println("Used in: " + aux.name());
				}
			}
		}
		if (!used) {
			System.out.println("feature not used");
		}
	}

}
