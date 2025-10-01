package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.util.TensorPrinter;
import org.openlca.sd.xmile.Xmile;

public class SimulatorExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/simple.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		var prnt = new TensorPrinter();
		var stock = Id.of("Natural\\nResources");
		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			} else {
				var state = res.value();
				var val = state.valueOf(stock).orElseThrow();
				prnt.print(val);
			}
		});
	}
}
