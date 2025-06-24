package org.openlca.sd.eqn;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.openlca.sd.eqn.generated.EqnLexer;
import org.openlca.sd.eqn.generated.EqnParser;

public class EvalInterpreter {

	private final EvalContext ctx;

	private EvalInterpreter(EvalContext ctx) {
		this.ctx = ctx;
	}

	public static EvalInterpreter of(EvalContext ctx) {
		return ctx != null
			? new EvalInterpreter(ctx)
			: new EvalInterpreter(new EvalContext());
	}

	public Cell eval(String expression) {
		if (Util.isEmpty(expression))
			return Cell.empty();
		var lexer = new EqnLexer(CharStreams.fromString(expression));
		var tokens = new CommonTokenStream(lexer);
		var parser = new EqnParser(tokens);
		return new EvalVisitor(ctx)
			.visit(parser.eqn());
	}

}
