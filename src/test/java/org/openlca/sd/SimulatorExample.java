package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.eqn.Vars;
import org.openlca.sd.xmile.Xmile;

public class SimulatorExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/simple.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();
		var vars = Vars.readFrom(xmile).orElseThrow();

		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			} else {
				var state = res.value();
				System.out.println("Iteration: " + state.iteration());
				for (var v : vars) {
					var varVal = state.valueOf(v.name()).orElseThrow();
					if (varVal.isNumCell()) {
						System.out.printf("  %s : %.2f%n", v.name().label(), varVal.asNum());
					}
				}
			}
		});
	}
}
