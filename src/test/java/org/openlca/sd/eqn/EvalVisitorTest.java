package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.openlca.sd.eqn.generated.EqnLexer;
import org.openlca.sd.eqn.generated.EqnParser;

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

	private double ev(String eqn) {
		return eval(eqn).asNumCell().value();
	}

	private boolean evb(String eqn) {
		return eval(eqn).asBoolCell().value();
	}

	private Cell eval(String eqn) {
		var lexer = new EqnLexer(CharStreams.fromString(eqn));
		var tokens = new CommonTokenStream(lexer);
		var parser = new EqnParser(tokens);
		return new EvalVisitor()
			.visit(parser.eqn());
	}

}
