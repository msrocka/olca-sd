package org.openlca.sd.eqn.func;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openlca.sd.eqn.Cell;
import org.openlca.sd.eqn.EvalContext;
import org.openlca.sd.eqn.Id;

public class FuncIntegrationTest {

	@Test
	public void testExpRndRegistered() {
		var context = new EvalContext();
		var func = context.getFunc(Id.of("EXPRND"));
		Assert.assertTrue("EXPRND should be registered", func.isPresent());

		var result = func.get().apply(List.of(Cell.of(5.0)));
		Assert.assertTrue("EXPRND should return a valid result", result.hasValue());
		Assert.assertTrue("EXPRND should return a number >= 0", result.orElseThrow().asNum() >= 0);
	}

	@Test
	public void testLogNormalRegistered() {
		var context = new EvalContext();
		var func = context.getFunc(Id.of("LOGNORMAL"));
		Assert.assertTrue("LOGNORMAL should be registered", func.isPresent());

		var result = func.get().apply(List.of(Cell.of(10.0), Cell.of(1.0)));
		Assert.assertTrue("LOGNORMAL should return a valid result", result.hasValue());
		Assert.assertTrue("LOGNORMAL should return a number >= 0", result.orElseThrow().asNum() >= 0);
	}

	@Test
	public void testRandomRegistered() {
		var context = new EvalContext();
		var func = context.getFunc(Id.of("RANDOM"));
		Assert.assertTrue("RANDOM should be registered", func.isPresent());

		var result = func.get().apply(List.of(Cell.of(1.0), Cell.of(100.0)));
		Assert.assertTrue("RANDOM should return a valid result", result.hasValue());
		var value = result.orElseThrow().asNum();
		Assert.assertTrue("RANDOM should return a number >= 1.0", value >= 1.0);
		Assert.assertTrue("RANDOM should return a number < 100.0", value < 100.0);
	}
}
