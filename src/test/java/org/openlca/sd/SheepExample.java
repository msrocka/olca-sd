package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.xmile.Xmile;

public class SheepExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/sheep.xml"));
		var sim = Simulator.of(xmile).orElseThrow();

		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			} else {
				var state = res.value();
				System.out.printf(
					"%d\t%.2f\t%.2f%n",
					state.iteration(),
					state.time(),
					state.valueOf(Id.of("sheep")).orElseThrow().asNum());
			}
		});
	}
}
