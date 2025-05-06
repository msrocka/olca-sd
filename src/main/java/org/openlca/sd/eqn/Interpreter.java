package org.openlca.sd.eqn;

import java.util.Stack;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.openlca.sd.eqn.EqnParser.AddSubContext;
import org.openlca.sd.eqn.EqnParser.MulDivContext;
import org.openlca.sd.eqn.EqnParser.NumberContext;
import org.openlca.sd.eqn.EqnParser.ParensContext;
import org.openlca.sd.eqn.EqnParser.PowerContext;

public class Interpreter extends EqnBaseListener {

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
		switch (ctx) {
			case NumberContext num -> enterNumber(num);
			case AddSubContext addSub -> enterAddSub(addSub);
			case MulDivContext mulDiv -> enterMulDiv(mulDiv);
			case PowerContext powCtx -> enterPower(powCtx);
			case ParensContext parens -> enterEveryRule(parens.eqn());
			default -> throw new IllegalArgumentException(
				"Unknown rule: " + ctx.getClass().getSimpleName());
		}
	}

	@Override
	public void enterAddSub(AddSubContext ctx) {
		enterEveryRule(ctx.eqn(0));
		enterEveryRule(ctx.eqn(1));
		var b = stack.pop();
		var a = stack.pop();
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
	public void enterMulDiv(MulDivContext ctx) {
		enterEveryRule(ctx.eqn(0));
		enterEveryRule(ctx.eqn(1));
		var b = stack.pop();
		var a = stack.pop();
		var op = (TerminalNode) ctx.getChild(1);
		var type = op.getSymbol().getType();

		var r = switch (type) {
			case EqnParser.MUL -> a * b;
			case EqnParser.DIV -> a / b;
			default -> throw new IllegalArgumentException(
				"Unknown operator: " + op.getText());
		};
		stack.push(r);
	}

	@Override
	public void enterPower(PowerContext ctx) {
		enterEveryRule(ctx.eqn(0));
		enterEveryRule(ctx.eqn(1));
		var b = stack.pop();
		var a = stack.pop();
		stack.push(Math.pow(a, b));
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
