package org.openlca.sd.eqn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.openlca.sd.eqn.cells.BoolCell;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.sd.eqn.cells.EmptyCell;
import org.openlca.sd.eqn.cells.EqnCell;
import org.openlca.sd.eqn.cells.LookupCell;
import org.openlca.sd.eqn.cells.NonNegativeCell;
import org.openlca.sd.eqn.cells.NumCell;
import org.openlca.sd.eqn.cells.TensorCell;
import org.openlca.sd.eqn.cells.TensorEqnCell;
import org.openlca.sd.eqn.func.Abs;
import org.openlca.sd.eqn.generated.EqnBaseListener;
import org.openlca.sd.eqn.generated.EqnLexer;
import org.openlca.sd.eqn.generated.EqnParser;
import org.openlca.sd.eqn.generated.EqnParser.ArrayAccessContext;
import org.openlca.sd.eqn.generated.EqnParser.VarContext;
import org.openlca.util.Res;

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

	public EvalContext context() {
		return ctx;
	}

	public Res<Cell> eval(Cell cell) {
		return switch (cell) {
			case BoolCell bool -> Res.of(bool);
			case EmptyCell empty -> Res.of(empty);
			case EqnCell(String eqn) -> eval(eqn);
			case NumCell num -> Res.of(num);
			case TensorCell(Tensor t) -> eval(t);

			case TensorEqnCell(Tensor t, String eqn) -> {
				if (t == null)
					yield Res.error("no tensor provided");
				var res = eval(eqn);
				if (res.hasError())
					yield res;
				var val = res.value();
				var result = t.copy();
				if (val instanceof TensorCell(Tensor r)) {
					for (int i = 0; i < Math.min(t.size(), r.size()); i++) {
						result.set(i, r.get(i));
					}
				} else {
					for (int i = 0; i < result.size(); i++) {
						result.set(i, val);
					}
				}
				yield Res.of(Cell.of(result));
			}

			case LookupCell(String eqn, LookupFunc func, List<Subscript> subs) -> {
				var res = eval(eqn);
				if (res.hasError())
					yield res;
				var val = res.value();
				if (val instanceof TensorCell(Tensor t)	&& subs != null	&& !subs.isEmpty()) {
					val = t.get(subs);
				}
				if (!(val instanceof NumCell(double  x))) {
					yield Res.error("equation of lookup function " +
						"does not evaluate to a number");
				}
				yield Res.of(Cell.of(func.get(x)));
			}

			case NonNegativeCell(Cell sub) -> {
				var res = eval(sub);
				yield res.hasError()
					? res
					: new Abs().apply(List.of(res.value()));
			}

			case null -> Res.error("no cell provided");
		};
	}

	private Res<Cell> eval(Tensor tensor) {
		if (tensor == null)
			return Res.error("no tensor provided");
		var res = Tensor.of(tensor.dimensions());
		for (int i = 0; i < tensor.size(); i++) {
			var cell = eval(tensor.get(i));
			if (cell.hasError())
				return cell;
			res.set(i, cell.value());
		}
		return Res.of(Cell.of(res));
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

		// predefined no-parameter functions that are not variables
		var fns = Set.of(
			Id.of("INF"),
			Id.of("PI"),
			Id.of("DT"),
			Id.of("STARTTIME"),
			Id.of("STOPTIME"),
			Id.of("TIME"),
			Id.of("SELF")
		);

		try {
			var lexer = new EqnLexer(CharStreams.fromString(expression));
			var tokens = new CommonTokenStream(lexer);
			var parser = new EqnParser(tokens);
			var tree = parser.eqn();

			var vars = new HashSet<Id>();
			Consumer<TerminalNode> pushVar = (node) -> {
				if (node == null)
					return;
				var v = Id.of(node.getText());
				if (!v.isNil() && !fns.contains(v)) {
					vars.add(v);
				}
			};

			var collector = new EqnBaseListener() {
				@Override
				public void enterVar(VarContext ctx) {
					pushVar.accept(ctx.ID());
				}

				@Override
				public void enterArrayAccess(ArrayAccessContext ctx) {
					pushVar.accept(ctx.ID());
				}
			};

			ParseTreeWalker.DEFAULT.walk(collector, tree);
			return Res.of(List.copyOf(vars));
		} catch (Exception e) {
			return Res.error("failed to collect vars from expression", e);
		}
	}

}
