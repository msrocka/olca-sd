package org.openlca.sd;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.Dimension;
import org.openlca.sd.eqn.Tensor;
import org.openlca.sd.util.TensorPrinter;

public class TensorExamples {

	public static void main(String[] args) {

		var printer = new TensorPrinter();

		var plastics = Dimension.of("Plastics", "PET", "PVC", "ABS");
		var metals = Dimension.of("Metals", "Fe", "Cu", "Al");

		var t1 = Tensor.of(plastics);
		printer.print(t1);


		var t2 = Tensor.of(plastics, metals);
		printer.print(t2);

		t2.set(0, Cell.of("X"));
		printer.print(t2);
	}

}
