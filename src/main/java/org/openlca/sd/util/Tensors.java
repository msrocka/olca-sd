package org.openlca.sd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.openlca.sd.eqn.Subscript;
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

	/// Returns the subscript addresses of all possible elements of this tensor.
	public static List<List<Subscript>> addressesOf(Tensor t) {
		if (t == null)
			return List.of();
		List<List<Subscript>> addresses = List.of();
		var dims = t.dimensions();
		for (var dim : dims) {
			if (addresses.isEmpty()) {
				addresses = new ArrayList<>(dim.size());
				for (var elem : dim.elements()) {
					addresses.add(List.of(Subscript.of(elem)));
				}
				continue;
			}

			int n = dim.size() * addresses.size();
			var next = new ArrayList<List<Subscript>>(n);
			for (var elem : dim.elements()) {
				for (var address : addresses) {
					var a = new ArrayList<Subscript>(address.size() + 1);
					a.addAll(address);
					a.add(Subscript.of(elem));
					next.add(a);
				}
			}
			addresses = next;
		}
		return addresses;
	}
}
