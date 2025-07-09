package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvalVisitorTest {

	@Test
	public void testAddSub() {
		assertEquals(5.0, ev("2 + 3"), 1e-10);
		assertEquals(7.0, ev("7 + 0"), 1e-10);
		assertEquals(-1.0, ev("2 + -3"), 1e-10);
		assertEquals(-8.0, ev("-5 + -3"), 1e-10);
		assertEquals(5.5, ev("2.5 + 3.0"), 1e-10);
		assertEquals(1000000.0, ev("500000 + 500000"), 1e-10);
		assertEquals(0.75, ev("-1.25 + 2.0"), 1e-10);
		assertEquals(6.0, ev("1 + 2 + 3"), 1e-10);
		assertEquals(2.0, ev("5 - 3"), 1e-10);
		assertEquals(8.0, ev("8 - 0"), 1e-10);
		assertEquals(5.0, ev("2 - -3"), 1e-10);
		assertEquals(-8.0, ev("-5 - 3"), 1e-10);
		assertEquals(-2.0, ev("-5 - -3"), 1e-10);
		assertEquals(0.5, ev("3.0 - 2.5"), 1e-10);
		assertEquals(-5.0, ev("2 - 7"), 1e-10);
		assertEquals(500000.0, ev("1000000 - 500000"), 1e-10);
		assertEquals(4.0, ev("10 - 4 - 2"), 1e-10);
		assertEquals(4.0, ev("1 + 2 - 3 + 4"), 1e-10);
		assertEquals(1.0, ev("5 - 3 + 2 - 3"), 1e-10);
		assertEquals(-5.0, ev("-5"), 1e-10);
		assertEquals(-3.0, ev("-5 + 2"), 1e-10);
		assertEquals(8.0, ev("5 - -3"), 1e-10);
	}

	@Test
	public void testMulDivMod() {

		assertEquals(6.0, ev("2 * 3"), 1e-10);
		assertEquals(0.0, ev("7 * 0"), 1e-10);
		assertEquals(-6.0, ev("2 * -3"), 1e-10);
		assertEquals(15.0, ev("-5 * -3"), 1e-10);
		assertEquals(7.5, ev("2.5 * 3.0"), 1e-10);
		assertEquals(1000000.0, ev("1000 * 1000"), 1e-10);

		assertEquals(2.0, ev("6 / 3"), 1e-10);
		assertEquals(-2.0, ev("6 / -3"), 1e-10);
		assertEquals(0.5, ev("3 / 6"), 1e-10);
		assertEquals(-2.5, ev("-5 / 2"), 1e-10);
		assertEquals(1.0, ev("10 / 10"), 1e-10);
		assertEquals(0.2, ev("1.0 / 5.0"), 1e-10);

		assertThrows(EvalException.class, () -> ev("10 / 0"));
		assertThrows(EvalException.class, () -> ev("5.0 / 0.0"));

		assertEquals(1.0, ev("7 % 3"), 1e-10);
		assertEquals(0.0, ev("6 % 3"), 1e-10);
		assertEquals(2.0, ev("10 % 4"), 1e-10);
		assertEquals(1.0, ev("5 % 2"), 1e-10);
		assertEquals(-1.0, ev("-7 % 3"), 1e-10);
		assertEquals(-2.0, ev("-10 % 4"), 1e-10);
		assertEquals(1.0, ev("7 % -3"), 1e-10);

		assertThrows(EvalException.class, () -> ev("10 % 0"));
		assertThrows(EvalException.class, () -> ev("5.0 % 0.0"));

		assertEquals(1.0, ev("7 MOD 3"), 1e-10);
		assertEquals(0.0, ev("6 MOD 3"), 1e-10);
		assertEquals(2.0, ev("10 MOD 4"), 1e-10);

		assertEquals(1.0, ev("7 mod 3"), 1e-10);
		assertEquals(0.0, ev("6 mod 3"), 1e-10);

		assertEquals(1.0, ev("7 Mod 3"), 1e-10);
		assertEquals(0.0, ev("6 Mod 3"), 1e-10);

		assertEquals(14.0, ev("2 + 3 * 4"), 1e-10);
		assertEquals(7.0, ev("10 - 6 / 2"), 1e-10);
		assertEquals(9.0, ev("2 * 5 - 1"), 1e-10);
		assertEquals(1.0, ev("8 / 4 - 1"), 1e-10);
		assertEquals(2.0, ev("1 + 6 % 5"), 1e-10);
		assertEquals(10.0, ev("10 + 2 * 0"), 1e-10);
		assertEquals(1.5, ev("12 / 6 * 2 / 4 + 0.5"), 1e-10);

		assertEquals(20.0, ev("(2 + 3) * 4"), 1e-10);
		assertEquals(2.0, ev("10 / (2 + 3)"), 1e-10);
		assertEquals(13.0, ev("2 * (3 + 4) - 5 / (6 - 1)"), 1e-10);
		assertEquals(0.0, ev("(7 - 1) % 3"), 1e-10);
	}

	@Test
	public void testPower() {

		assertEquals(8.0, ev("2^3"), 1e-10);
		assertEquals(9.0, ev("3**2"), 1e-10);
		assertEquals(16.0, ev("2^4"), 1e-10);
		assertEquals(125.0, ev("5**3"), 1e-10);

		assertEquals(1.0, ev("5^0"), 1e-10);
		assertEquals(1.0, ev("123.45**0"), 1e-10);
		assertEquals(0.0, ev("0^5"), 1e-10);
		assertEquals(1.0, ev("1^10"), 1e-10);
		assertEquals(1.0, ev("1**100"), 1e-10);
		assertEquals(0.0, ev("0.0^5.0"), 1e-10);
		assertEquals(1.0, ev("0^0"), 1e-10);

		assertEquals(0.25, ev("2^-2"), 1e-10);
		assertEquals(0.125, ev("2.0**-3.0"), 1e-10);
		assertEquals(0.04, ev("5^-2"), 1e-10);

		assertEquals(3.0, ev("9^0.5"), 1e-10);
		assertEquals(2.0, ev("8**(1/3.0)"), 1e-10);
		assertEquals(2.0, ev("8**(0.333333333333333333)"), 1e-10);

		assertEquals(6.25, ev("2.5^2"), 1e-10);
		assertEquals(0.0625, ev("0.5**4"), 1e-10);

		assertEquals(-8.0, ev("(-2)^3"), 1e-10);
		assertEquals(4.0, ev("(-2)^2"), 1e-10);
		assertEquals(Double.NaN, ev("(-4)^0.5"), 1e-10);

		assertEquals(10.0, ev("2 + 2^3"), 1e-10);
		assertEquals(18.0, ev("2 * 3^2"), 1e-10);
		assertEquals(1.0, ev("16 / 2^3 + 1 - 2"), 1e-10);

		assertEquals(512.0, ev("2^3^2"), 1e-10);
		assertEquals(81.0, ev("3**2**2"), 1e-10);
		assertEquals(64.0, ev("(2^3)^2"), 1e-10);

		assertEquals(50.0, ev("(2 + 3)^2 * 2"), 1e-10);
		assertEquals(17.0, ev("3 + (2^3 - 1) * 2"), 1e-10);

		assertEquals(1.0E308, ev("10^308"), 1e-10);
		assertEquals(1.0E-308, ev("0.1^308"), 1e-10);
	}

	@Test
	public void testComp() {

		assertTrue(evb("5 == 5"));
		assertTrue(evb("5 = 5"));
		assertFalse(evb("5 == 6"));
		assertFalse(evb("5 = 6"));
		assertTrue(evb("3.14 == 3.14"));
		assertFalse(evb("3.14 == 3.141"));
		assertTrue(evb("0 == 0"));
		assertFalse(evb("0 == 1"));
		assertTrue(evb("(2 + 3) == 5"));
		assertFalse(evb("(2 + 3) == 6"));

		assertTrue(evb("5 != 6"));
		assertTrue(evb("5 <> 6"));
		assertFalse(evb("5 != 5"));
		assertFalse(evb("5 <> 5"));
		assertTrue(evb("3.14 != 3.141"));
		assertFalse(evb("3.14 != 3.14"));
		assertTrue(evb("0 != 1"));
		assertFalse(evb("0 != 0"));
		assertTrue(evb("(2 + 3) != 6"));
		assertFalse(evb("(2 + 3) != 5"));

		assertTrue(evb("5 < 6"));
		assertFalse(evb("6 < 5"));
		assertFalse(evb("5 < 5"));
		assertTrue(evb("3.0 < 3.1"));
		assertFalse(evb("3.1 < 3.0"));
		assertFalse(evb("3.0 < 3.0"));
		assertTrue(evb("-5 < -2"));
		assertFalse(evb("-2 < -5"));
		assertTrue(evb("2 * 3 < 7"));

		assertTrue(evb("6 > 5"));
		assertFalse(evb("5 > 6"));
		assertFalse(evb("5 > 5"));
		assertTrue(evb("3.1 > 3.0"));
		assertFalse(evb("3.0 > 3.1"));
		assertFalse(evb("3.0 > 3.0"));
		assertTrue(evb("-2 > -5"));
		assertFalse(evb("-5 > -2"));
		assertTrue(evb("10 / 2 > 4"));

		assertTrue(evb("5 <= 6"));
		assertTrue(evb("5 <= 5"));
		assertFalse(evb("6 <= 5"));
		assertTrue(evb("3.0 <= 3.1"));
		assertTrue(evb("3.0 <= 3.0"));
		assertFalse(evb("3.1 <= 3.0"));
		assertTrue(evb("-5 <= -2"));
		assertTrue(evb("-5 <= -5"));
		assertTrue(evb("2^3 <= 8"));

		assertTrue(evb("6 >= 5"));
		assertTrue(evb("5 >= 5"));
		assertFalse(evb("5 >= 6"));
		assertTrue(evb("3.1 >= 3.0"));
		assertTrue(evb("3.0 >= 3.0"));
		assertFalse(evb("3.0 >= 3.1"));
		assertTrue(evb("-2 >= -5"));
		assertTrue(evb("-5 >= -5"));
		assertTrue(evb("10 / 2 >= 5"));

		assertTrue(evb("2 + 3 == 5"));
		assertFalse(evb("2 * 3 > 7"));
		assertTrue(evb("10 - 2 <= 8"));
		assertFalse(evb("10 / 2 != 5"));
		assertTrue(evb("2^3 >= 7"));
		assertTrue(evb("5 + 2 * 3 > 10"));
		assertTrue(evb("15 % 4 <= 3"));
		assertFalse(evb("10 / 2 * 3 != 15"));
	}

	@Test
	public void testLogical() {

		assertTrue(evb("NOT (5 == 6)"));
		assertFalse(evb("NOT (5 == 5)"));
		assertTrue(evb("not (10 < 5)"));
		assertFalse(evb("not (10 > 5)"));
		assertTrue(evb("!(5 == 6)"));
		assertFalse(evb("!(5 == 5)"));

		assertTrue(evb("(5 == 5) AND (6 == 6)"));
		assertFalse(evb("(5 == 5) AND (6 == 7)"));
		assertFalse(evb("(5 == 6) AND (6 == 6)"));
		assertFalse(evb("(5 == 6) AND (6 == 7)"));
		assertTrue(evb("(2 < 3) and (4 > 1)"));
		assertFalse(evb("(2 < 3) and (4 < 1)"));
		assertTrue(evb("(5 == 5) & (6 == 6)"));

		assertTrue(evb("(5 == 5) OR (6 == 6)"));
		assertTrue(evb("(5 == 5) OR (6 == 7)"));
		assertTrue(evb("(5 == 6) OR (6 == 6)"));
		assertFalse(evb("(5 == 6) OR (6 == 7)"));
		assertTrue(evb("(2 < 3) or (4 < 1)"));
		assertTrue(evb("(5 == 5) | (6 == 7)"));

		assertTrue(evb("(2 + 3 == 5) AND (10 > 9)"));
		assertFalse(evb("(2 * 4 < 5) OR (7 == 7 AND 8 != 8)"));
		assertFalse(evb("NOT (5 * 2 == 10) OR (3 + 1 == 5)"));
		assertTrue(evb("!(10 / 2 < 3) AND (7 % 2 == 1)"));
		assertTrue(evb("(2^3 == 8) AND (1 = 1)"));

		assertTrue(evb("(5 > 3 AND 7 < 10) OR (2 == 2 AND 4 != 4)"));
		assertFalse(evb("NOT ((1 + 1 == 2) OR (3 * 3 == 8))"));
		assertTrue(evb("((10 > 5) AND !(12 < 10)) OR (1 + 1 == 3)"));
	}

	@Test
	public void testIfThenElse() {
		assertEquals(10.0, ev("IF 5 > 3 THEN 10 ELSE 20"), 1e-10);
		assertEquals(20.0, ev("IF (5 < 3) THEN 10 ELSE 20"), 1e-10);
		assertEquals(1.0, ev("IF 2 == 2 THEN 1 ELSE 0"), 1e-10);
		assertEquals(0.0, ev("IF (2 != 2) THEN 1 ELSE 0"), 1e-10);

		assertTrue(evb("IF (5 > 3) THEN (7 == 7) ELSE (8 == 9)"));
		assertFalse(evb("IF (5 < 3) THEN (7 == 7) ELSE (8 == 9)"));
		assertTrue(evb("IF (10 >= 10) THEN (1 == 1) ELSE (2 == 3)"));
		assertFalse(evb("IF (10 < 10) THEN (1 == 1) ELSE (2 == 3)"));

		assertEquals(100.0, ev("IF (5 > 3) THEN (IF (2 == 2) THEN 100 ELSE 200) ELSE 300"), 1e-10);
		assertEquals(200.0, ev("IF (5 > 3) THEN (IF (2 != 2) THEN 100 ELSE 200) ELSE 300"), 1e-10);
		assertEquals(300.0, ev("IF (5 < 3) THEN (IF (2 == 2) THEN 100 ELSE 200) ELSE 300"), 1e-10);

		assertEquals(15.0, ev("IF 3 * 2 == 6 THEN 10 + 5 ELSE 20 - 5"), 1e-10);
		assertEquals(15.0, ev("IF (3 * 2 != 6) THEN (10 + 5) ELSE (20 - 5)"), 1e-10);
		assertEquals(25.0, ev("IF (5^2 == 25) THEN (2 * 10 + 5) ELSE (100 / 4)"), 1e-10);

		assertEquals(42.0, ev("IF (5 > 3) AND (10 == 10) THEN 42 ELSE 99"), 1e-10);
		assertEquals(99.0, ev("IF ((5 < 3) AND (10 == 10)) THEN 42 ELSE 99"), 1e-10);
		assertEquals(42.0, ev("IF ((5 < 3) OR (10 == 10)) THEN 42 ELSE 99"), 1e-10);
		assertEquals(42.0, ev("IF (NOT (5 < 3)) THEN 42 ELSE 99"), 1e-10);

		assertEquals(7.0, ev("IF 2 + 3 == 5 THEN 3 + 4 ELSE 5 + 6"), 1e-10);
		assertEquals(11.0, ev("IF (2 + 3 != 5) THEN (3 + 4) ELSE (5 + 6)"), 1e-10);

		assertThrows(EvalException.class, () -> ev("IF 5 THEN 10 ELSE 20"));
		assertThrows(EvalException.class, () -> ev("IF (2 + 3) THEN 10 ELSE 20"));
	}

	@Test
	public void testVars() {
		var ctx = new EvalContext()
			.bind("a", 20)
			.bind("b", 2);
		assertEquals(42, eval("a * b + 2", ctx).asNum(), 1e-10);

		// basic variable substitution
		assertEquals(25.0, eval("x + y",
			new EvalContext()
				.bind("x", 10)
				.bind("y", 15)).asNum(), 1e-10);
		assertEquals(50.0, eval("price * quantity",
			new EvalContext()
				.bind("price", 5.0)
				.bind("quantity", 10)).asNum(), 1e-10);

		// variables in complex expressions
		assertEquals(11.025, eval("base * (1 + rate)^time",
			new EvalContext()
				.bind("base", 10)
				.bind("rate", 0.05)
				.bind("time", 2)).asNum(), 1e-10);

		// variable case insensitivity
		var caseCtx = new EvalContext()	.bind("Value", 42);
		assertEquals(42.0, eval("Value", caseCtx).asNum(), 1e-10);
		assertEquals(42.0, eval("value", caseCtx).asNum(), 1e-10);
		assertEquals(42.0, eval("VALUE", caseCtx).asNum(), 1e-10);

		// variables with special numeric values
		var specialCtx = new EvalContext()
			.bind("zero", 0)
			.bind("negative", -15.5)
			.bind("fraction", 0.333333)
			.bind("large", 1e6)
			.bind("small", 1e-6);
		assertEquals(0.0, eval("zero", specialCtx).asNum(), 1e-10);
		assertEquals(-15.5, eval("negative", specialCtx).asNum(), 1e-10);
		assertEquals(0.333333, eval("fraction", specialCtx).asNum(), 1e-10);
		assertEquals(1e6, eval("large", specialCtx).asNum(), 1e-10);
		assertEquals(1e-6, eval("small", specialCtx).asNum(), 1e-10);

		// variables in logical expressions
		var logicalCtx = new EvalContext()
			.bind("isTrue", 1)
			.bind("isFalse", 0)
			.bind("threshold", 50);
		assertTrue(eval("isTrue == 1", logicalCtx).asBool());
		assertFalse(eval("isFalse == 1", logicalCtx).asBool());
		assertTrue(eval("threshold > 25", logicalCtx).asBool());

		// variables in IF-THEN-ELSE
		var condCtx = new EvalContext()
			.bind("condition", 1)
			.bind("trueValue", 42)
			.bind("falseValue", 99);
		assertEquals(42.0,
			eval("IF (condition == 1) THEN trueValue ELSE falseValue", condCtx)
				.asNum(), 1e-10);

		condCtx.bind("condition", 0);
		assertEquals(99.0,
			eval("IF (condition == 1) THEN trueValue ELSE falseValue", condCtx)
				.asNum(), 1e-10);

		// variable shadowing/overriding
		var shadowCtx = new EvalContext()
			.bind("x", 10)
			.bind("x", 20); // override the previous value
		assertEquals(20.0, eval("x", shadowCtx).asNumCell().value(), 1e-10);

		// variables with underscores and numbers
		var namingCtx = new EvalContext()
			.bind("var_1", 10)
			.bind("var_2", 20)
			.bind("total_sum", 100)
			.bind("x1", 5)
			.bind("y2", 15);
		assertEquals(30.0, eval("var_1 + var_2", namingCtx).asNum(), 1e-10);
		assertEquals(100.0, eval("total_sum", namingCtx).asNum(), 1e-10);
		assertEquals(20.0, eval("x1 + y2", namingCtx).asNum(), 1e-10);

		// Test variables in modulo operations
		var modCtx = new EvalContext()
			.bind("dividend", 17)
			.bind("divisor", 5);
		assertEquals(2.0, eval("dividend % divisor", modCtx).asNum(), 1e-10);
		assertEquals(2.0, eval("dividend MOD divisor", modCtx).asNum(), 1e-10);

		// variables in power operations
		var powerCtx = new EvalContext()
			.bind("base_val", 2)
			.bind("exponent", 8);
		assertEquals(256.0, eval("base_val^exponent", powerCtx).asNum(), 1e-10);
		assertEquals(256.0, eval("base_val**exponent", powerCtx).asNum(), 1e-10);

		// multiple variables in nested operations
		var nestedCtx = new EvalContext()
			.bind("a1", 2)
			.bind("b1", 3)
			.bind("c1", 4)
			.bind("d1", 5);
		assertEquals(50.0, eval("(a1 + b1) * (c1 + d1) + (a1 * c1) - b1", nestedCtx)
			.asNum(), 1e-10);

		// undefined variable should throw exception
		assertThrows(EvalException.class,
			() -> eval("undefined_var", new EvalContext()));
		assertThrows(EvalException.class,
			() -> eval("x + y", new EvalContext().bind("x", 10)));

			// variables with extreme values
		var extremeCtx = new EvalContext()
			.bind("maxVal", Double.MAX_VALUE)
			.bind("minVal", Double.MIN_VALUE)
			.bind("posInf", Double.POSITIVE_INFINITY)
			.bind("negInf", Double.NEGATIVE_INFINITY)
			.bind("notANumber", Double.NaN);
		assertEquals(Double.MAX_VALUE, eval("maxVal", extremeCtx).asNum(), 1e-10);
		assertEquals(Double.MIN_VALUE, eval("minVal", extremeCtx).asNum(), 1e-10);
		assertEquals(Double.POSITIVE_INFINITY, eval("posInf", extremeCtx).asNum(), 1e-10);
		assertEquals(Double.NEGATIVE_INFINITY, eval("negInf", extremeCtx).asNum(), 1e-10);
		assertEquals(Double.NaN, eval("notANumber", extremeCtx).asNum(), 1e-10);
	}

	private double ev(String eqn) {
		return eval(eqn, new EvalContext()).asNumCell().value();
	}

	private boolean evb(String eqn) {
		return eval(eqn, new EvalContext()).asBoolCell().value();
	}

	private Cell eval(String eqn, EvalContext ctx) {
		return EvalInterpreter.of(ctx).eval(eqn);
	}

}
