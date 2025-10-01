package org.openlca.sd;

import java.util.Objects;

import org.openlca.sd.eqn.Tensor;

public class Tensors {

	private Tensors() {
	}

	public static boolean haveSameDimensions(Tensor a, Tensor b) {
		if (a == null || b == null)
			return false;
		var dimsA = a.dimensions();
		var dimsB = b.dimensions();
		if (dimsA.size() != dimsB.size())
			return false;
		for (int i = 0; i < dimsA.size(); i++) {
			if (!Objects.equals(dimsA.get(i), dimsB.get(i)))
				return false;
		}
		return true;
	}
}
