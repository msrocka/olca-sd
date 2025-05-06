package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleParserTest {

	@Test
	public void testNumbers() {
		assertEquals(1.0, ev("1"), 1e-10);
		assertEquals(0.523, ev("0.523"), 1e-10);
		assertEquals(0.523, ev(".523"), 1e-10);
		assertEquals(0.523, ev("5.23e-1"), 1e-10);
	}

	@Test
	public void testAddSub() {
		assertEquals(3.0, ev("1 + 2"), 1e-10);
	}

	@Test
	public void testPrecedence() {
		assertEquals(7, ev("1 + 2 * 3"), 1e-10);
		assertEquals(9, ev("(1 + 2) * 3"), 1e-10);
		assertEquals(7, ev("2 * 3 + 1"), 1e-10);
		assertEquals(8, ev("2 * (3 + 1)"), 1e-10);
	}

	@Test
	public void testPow() {
		assertEquals(8.0, ev("2^3"), 1e-10);
		assertEquals(10.0, ev("2+2^3"), 1e-10);
		assertEquals(16.0, ev("2*2^3"), 1e-10);
		assertEquals(64.0, ev("(2 + 2)^3"), 1e-10);
	}

	private double ev(String eqn) {
		return new Interpreter().eval(eqn);
	}
}
