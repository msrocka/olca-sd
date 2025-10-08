package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Simulator;
import org.openlca.sd.util.CsvWriter;
import org.openlca.sd.xmile.Xmile;

public class CsvWriterExample {

	public static void main(String[] args) {
		var file = new File("examples/res-pop-arrays-c.csv");
		var xmile = Xmile
			.readFrom(new File("examples/res-pop-arrays.stmx"))
			.orElseThrow();
		var sim = Simulator.of(xmile).orElseThrow();
		CsvWriter.of(sim, file).run().orElseThrow();
	}

}
