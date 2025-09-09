package org.openlca.sd.eqn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvalTensorTest {

	@Test
	public void testSimpleEval() {
		var dimX = Dimension.of("X", "a", "b");
		var dimY = Dimension.of("Y", "d", "e");
		var t = Tensor.of(dimX, dimY);
		t.setAll(Cell.of("1"));

		var interpreter = Interpreter.of(new EvalContext());
		var res = interpreter.eval(Cell.of(t)).orElseThrow();

		var resT = res.asTensorCell().value();
		for (var x : dimX.elements()) {
			for (var y : dimY.elements()) {
				var val = resT.get(Subscript.of(x), Subscript.of(y)).asNum();
				assertEquals(1.0, val, 1e-10);
			}
		}
	}

}
