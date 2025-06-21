package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class EvalVisitorTest {

	@Test
	public void testAddSub() {
		var eqn = "1 + 2";
		var lexer = new org.openlca.sd.eqn.EqnLexer(CharStreams.fromString(eqn));
		var tokens = new CommonTokenStream(lexer);
		var parser = new org.openlca.sd.eqn.EqnParser(tokens);
		var res = new EvalVisitor()
			.visit(parser.eqn())
			.asNumCell()
			.value();
		assertEquals(3.0, res, 1e-10);
	}

}
