package org.openlca.sd.eqn;

import java.util.HashSet;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.openlca.sd.eqn.generated.EqnBaseListener;
import org.openlca.sd.eqn.generated.EqnLexer;
import org.openlca.sd.eqn.generated.EqnParser;
import org.openlca.sd.eqn.generated.EqnParser.ArrayAccessContext;
import org.openlca.sd.eqn.generated.EqnParser.VarContext;
import org.openlca.sd.util.Res;

public class Interpreter {

	private final EvalContext ctx;

	private Interpreter(EvalContext ctx) {
		this.ctx = ctx;
	}

	public static Interpreter of(EvalContext ctx) {
		return ctx != null
			? new Interpreter(ctx)
			: new Interpreter(new EvalContext());
	}

	public Res<Cell> eval(String expression) {
		if (Util.isEmpty(expression))
			return Res.error("empty expression provided");
		var lexer = new EqnLexer(CharStreams.fromString(expression));
		var tokens = new CommonTokenStream(lexer);
		var parser = new EqnParser(tokens);
		return new EvalVisitor(ctx).visit(parser.eqn());
	}

	public static Res<List<Id>> varsOf(String expression) {
		if (Util.isEmpty(expression))
			return Res.error("provided expression is empty");
		try {
			var lexer = new EqnLexer(CharStreams.fromString(expression));
			var tokens = new CommonTokenStream(lexer);
			var parser = new EqnParser(tokens);
			var tree = parser.eqn();

			var vars = new HashSet<Id>();
			var collector = new EqnBaseListener() {
				@Override
				public void enterVar(VarContext ctx) {
					if (ctx.ID() == null)
						return;
					var id = Id.of(ctx.ID().getText());
					vars.add(id);
				}

				@Override
				public void enterArrayAccess(ArrayAccessContext ctx) {
					if (ctx.ID() == null)
						return;
					var id = Id.of(ctx.ID().getText());
					vars.add(id);
				}
			};

			ParseTreeWalker.DEFAULT.walk(collector, tree);
			return Res.of(List.copyOf(vars));
		} catch (Exception e) {
			return Res.error("failed to collect vars from expression", e);
		}
	}

}
