package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.util.TensorPrinter;
import org.openlca.sd.xmile.Xmile;

public class FullExample {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var sim = Simulator.of(xmile).orElseThrow();

		var prnt = new TensorPrinter();
		var interpreter = sim.interpreter();

		var res = interpreter.eval("production_recyclate_factor").orElseThrow();
		prnt.print(res);

		res = interpreter.eval(res).orElseThrow();
		prnt.print(res);
		interpreter.context()
			.getVar(Id.of("production_recyclate_factor"))
			.orElseThrow()
			.pushValue(res);

		var cell = interpreter.eval("""
			production_recyclate_factor[EoL_Class,Product_1]
			+ production_recyclate_factor[EoL_Class,Product_2]""");
		prnt.print(cell.value());

		/*
		sim.forEach(res -> {
			if (res.hasError()) {
				System.out.println("error: " + res.error());
			}
		});

		 */
	}
}
