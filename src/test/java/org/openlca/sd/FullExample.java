package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.xmile.Xmile;

public class FullExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			}
		});
	}
}
