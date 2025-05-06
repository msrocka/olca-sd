package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import org.junit.Test;

public class TensorTest {

	@Test
	public void test1D() {
		var dim = Dimension.of("dim", "a", "b", "c");
		var t = Tensor.of(dim);
		t.setAll(42);
		assertEquals(1, t.dimensions());
		assertEquals(3, t.size());

		assertEquals(t, t.get("*").getAsTensorCell().tensor());
		assertEquals(t, t.get("dim").getAsTensorCell().tensor());

		for (var elem : dim.elements()) {
			assertEquals(42, t.get(elem).getAsNumberCell().number(), 1e-16);
		}

		t.set("b", 21);
		assertEquals(21, t.get("b").getAsNumberCell().number(), 1e-16);

	}


	@Test
	public void test2D() {
		var dim1 = Dimension.of("Products", "PET", "PVC", "Nylon");
		var dim2 = Dimension.of("Location", "GLO", "US", "DE", "FR");
		var shares = Tensor.of(dim1, dim2);

		shares.set("PET", "GLO", 0.3);
		shares.set("PVC", "*", 0.1);
		shares.set("Nylon", 0.2);

	}

}


