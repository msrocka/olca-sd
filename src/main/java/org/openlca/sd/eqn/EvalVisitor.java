package org.openlca.sd.eqn;

import org.openlca.sd.eqn.Cell.NumCell;
import org.openlca.sd.eqn.generated.EqnBaseVisitor;
import org.openlca.sd.eqn.generated.EqnParser;
import org.openlca.sd.eqn.generated.EqnParser.AddSubContext;
import org.openlca.sd.eqn.generated.EqnParser.MulDivContext;
import org.openlca.sd.eqn.generated.EqnParser.NumberContext;
import org.openlca.sd.eqn.generated.EqnParser.ParensContext;
import org.openlca.sd.eqn.generated.EqnParser.UnarySignContext;

class EvalVisitor extends EqnBaseVisitor<Cell> {

	@Override
	public Cell visitAddSub(AddSubContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		return switch (ctx.op.getType()) {
			case EqnParser.ADD ->CellOps.add(a, b);
			case EqnParser.SUB -> CellOps.sub(a, b);
			default -> throw EvalException.of(
				"unsupported operator in add-sub context: " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitUnarySign(UnarySignContext ctx) {
		var cell = visit(ctx.eqn());
		if (!(cell instanceof NumCell(double x)))
			throw EvalException.of("unary operator " + ctx.op.getText()
				+ " not supported for " + cell);

		return switch (ctx.op.getType()) {
			case EqnParser.ADD -> Cell.of(x);
			case EqnParser.SUB -> Cell.of(-x);
			default -> throw EvalException.of(
				"unsupported unary operator " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitMulDiv(MulDivContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		return switch (ctx.op.getType()) {
			case EqnParser.MUL ->CellOps.mul(a, b);
			case EqnParser.DIV -> CellOps.div(a, b);
			case EqnParser.MOD -> CellOps.mod(a, b);
			default -> throw EvalException.of(
				"unsupported operator in mul-div context: " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitParens(ParensContext ctx) {
		return visit(ctx.eqn());
	}

	@Override
	public Cell visitNumber(NumberContext ctx) {
		var num = Double.parseDouble(ctx.getText());
		return Cell.of(num);
	}

}
