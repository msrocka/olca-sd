package org.openlca.sd.eqn;

import static org.junit.Assert.*;

import java.util.Stack;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;
import org.openlca.sd.eqn.EqnParser.AddSubContext;
import org.openlca.sd.eqn.EqnParser.NumberContext;

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
		assertEquals(3.0, new Interpreter().eval("1 + 2"), 1e-10);
	}

	private double ev(String eqn) {
		return new Interpreter().eval(eqn);
	}


	private static final class Interpreter extends EqnBaseListener {

		private final Stack<Double> stack = new Stack<>();

		public double eval(String eqn) {
			var lexer = new EqnLexer(CharStreams.fromString(eqn));
			var tokens = new CommonTokenStream(lexer);
			var parser = new EqnParser(tokens);
			enterEveryRule(parser.eqn());
			if (stack.isEmpty()) {
				throw new IllegalStateException("Stack is empty");
			}
			return stack.pop();
		}

		@Override
		public void enterEveryRule(ParserRuleContext ctx) {
			if (ctx instanceof NumberContext num) {
				enterNumber(num);
			} else if (ctx instanceof AddSubContext addSub) {
				enterAddSub(addSub);
			} else {
				throw new IllegalArgumentException(
					"Unknown rule: " + ctx.getClass().getSimpleName());
			}
		}

		@Override
		public void enterAddSub(AddSubContext ctx) {
			enterEveryRule(ctx.eqn(0));
			enterEveryRule(ctx.eqn(1));
			var a = stack.pop();
			var b = stack.pop();
			var op = (TerminalNode) ctx.getChild(1);
			var type = op.getSymbol().getType();

			if (type == EqnParser.ADD) {
				stack.push(a + b);
			} else if (type == EqnParser.SUB){
				stack.push(a - b);
			} else {
				throw new IllegalArgumentException("Unknown operator: " + op.getText());
			}
		}

		@Override
		public void enterNumber(NumberContext ctx) {
			var s = ctx.getText();
			try {
				var d = Double.parseDouble(s);
				stack.push(d);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Invalid number: " + s, e);
			}
		}
	}
}
