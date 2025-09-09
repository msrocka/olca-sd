package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.xmile.Xmile;

public class SimulatorExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/Resources-and-Population.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		var stock = Id.of("Population");
		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			} else {
				var state = res.value();
				System.out.printf(
					"%d  %.2f  %.2f%n",
					state.iteration(),
					state.time(),
					state.valueOf(stock).orElseThrow().asNum());
			}
		});
	}
}
