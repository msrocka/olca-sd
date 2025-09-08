package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.xmile.Xmile;

public class SimulatorExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/Resources-and-Population.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();
		var vars = sim.run().orElseThrow();

		for (var v : vars) {
			System.out.println(v.name().label());
			for (var val : v.values()) {
				System.out.println(val);
			}
		}

	}

}
