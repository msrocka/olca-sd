package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.util.TensorPrinter;
import org.openlca.sd.xmile.Xmile;

public class SimulatorArrayExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/Resources-and-Population_arrayed.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		var stock = Id.of("Population");
		var printer = new TensorPrinter();
		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			} else {
				var state = res.value();
				printer.print(state.valueOf(stock).orElseThrow());
			}
		});
	}
}
