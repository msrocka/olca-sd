package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.xmile.Xmile;

public class SimulatorExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/testing.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		var vid = Id.of("reuse");
		System.out.println("results of: " + vid);
		for (var res : sim) {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
				break;
			}
			var state = res.value();
			var v = state.valueOf(vid).orElseThrow().asNum();
			System.out.printf("%d\t%.2f\t%.2f%n",
				state.iteration(),
				state.time(),
				v);
		}
	}
}
