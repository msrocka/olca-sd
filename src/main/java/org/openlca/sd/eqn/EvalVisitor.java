package org.openlca.sd.eqn;

import java.util.Objects;

import org.openlca.sd.eqn.Cell.NumCell;
import org.openlca.sd.eqn.generated.EqnBaseVisitor;
import org.openlca.sd.eqn.generated.EqnParser;
import org.openlca.sd.eqn.generated.EqnParser.AddSubContext;
import org.openlca.sd.eqn.generated.EqnParser.CompContext;
import org.openlca.sd.eqn.generated.EqnParser.IfThenElseContext;
import org.openlca.sd.eqn.generated.EqnParser.LogicContext;
import org.openlca.sd.eqn.generated.EqnParser.MulDivContext;
import org.openlca.sd.eqn.generated.EqnParser.NotContext;
import org.openlca.sd.eqn.generated.EqnParser.NumberContext;
import org.openlca.sd.eqn.generated.EqnParser.ParensContext;
import org.openlca.sd.eqn.generated.EqnParser.PowerContext;
import org.openlca.sd.eqn.generated.EqnParser.UnarySignContext;
import org.openlca.sd.eqn.generated.EqnParser.VarContext;

class EvalVisitor extends EqnBaseVisitor<Cell> {

	private final EvalContext evalCtx;

	EvalVisitor(EvalContext evalCtx) {
		this.evalCtx = Objects.requireNonNull(evalCtx);
	}

	@Override
	public Cell visitAddSub(AddSubContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		return switch (ctx.op.getType()) {
			case EqnParser.ADD -> CellOps.add(a, b);
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
			case EqnParser.MUL -> CellOps.mul(a, b);
			case EqnParser.DIV -> CellOps.div(a, b);
			case EqnParser.MOD -> CellOps.mod(a, b);
			default -> throw EvalException.of(
				"unsupported operator in mul-div context: " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitComp(CompContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		if (!a.isNumCell() || !b.isNumCell())
			throw EvalException.unsupported(ctx.op.getText(), a, b);
		double x = a.asNumCell().value();
		double y = b.asNumCell().value();
		return switch (ctx.op.getType()) {
			case EqnParser.EQ -> Cell.of(x == y);
			case EqnParser.NEQ -> Cell.of(x != y);
			case EqnParser.GE -> Cell.of(x >= y);
			case EqnParser.GT -> Cell.of(x > y);
			case EqnParser.LE -> Cell.of(x <= y);
			case EqnParser.LT -> Cell.of(x < y);
			default -> throw EvalException.of(
				"unsupported operator in comp context: " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitNot(NotContext ctx) {
		var cell = visit(ctx.eqn());
		if (!cell.isBoolCell())
			throw EvalException.of(
				"NOT operator requires boolean operand, got: " + cell);
		boolean value = cell.asBoolCell().value();
		return Cell.of(!value);
	}

	@Override
	public Cell visitLogic(LogicContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		if (!a.isBoolCell() || !b.isBoolCell())
			throw EvalException.unsupported(ctx.op.getText(), a, b);
		boolean x = a.asBoolCell().value();
		boolean y = b.asBoolCell().value();
		return switch (ctx.op.getType()) {
			case EqnParser.AND -> Cell.of(x && y);
			case EqnParser.OR -> Cell.of(x || y);
			default -> throw EvalException.of(
				"unsupported operator in logic context: " + ctx.op.getText());
		};
	}

	@Override
	public Cell visitIfThenElse(IfThenElseContext ctx) {
		var cond = visit(ctx.eqn(0));
		if (!cond.isBoolCell())
			throw EvalException.of(
				"IF condition must be boolean, got: " + cond);
		return cond.asBoolCell().value()
			? visit(ctx.eqn(1))
			: visit(ctx.eqn(2));
	}

	@Override
	public Cell visitParens(ParensContext ctx) {
		return visit(ctx.eqn());
	}

	@Override
	public Cell visitPower(PowerContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));
		return CellOps.pow(a, b);
	}

	@Override
	public Cell visitNumber(NumberContext ctx) {
		var num = Double.parseDouble(ctx.getText());
		return Cell.of(num);
	}

	@Override
	public Cell visitVar(VarContext ctx) {
		return evalCtx.get(ctx.getText());
	}
}
