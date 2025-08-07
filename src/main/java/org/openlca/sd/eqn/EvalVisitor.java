package org.openlca.sd.eqn;

import java.util.Objects;

import org.openlca.sd.eqn.func.Add;
import org.openlca.sd.eqn.func.Div;
import org.openlca.sd.eqn.func.Mod;
import org.openlca.sd.eqn.func.Mul;
import org.openlca.sd.eqn.func.Neg;
import org.openlca.sd.eqn.func.Pow;
import org.openlca.sd.eqn.func.Sub;
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
import org.openlca.sd.util.Res;

class EvalVisitor extends EqnBaseVisitor<Res<Cell>> {

	private final EvalContext evalCtx;

	EvalVisitor(EvalContext evalCtx) {
		this.evalCtx = Objects.requireNonNull(evalCtx);
	}

	@Override
	public Res<Cell> visitAddSub(AddSubContext ctx) {
		var a = visit(ctx.eqn(0));
		if (a.hasError())
			return a;
		var b = visit(ctx.eqn(1));
		if (b.hasError())
			return b;

		return switch (ctx.op.getType()) {
			case EqnParser.ADD -> Add.apply(a.value(), b.value());
			case EqnParser.SUB -> Sub.apply(a.value(), b.value());
			default -> Res.error(
				"operator not supported: " + a.value() + ctx.op.getText() + b.value());
		};
	}

	@Override
	public Res<Cell> visitUnarySign(UnarySignContext ctx) {
		var res = visit(ctx.eqn());
		if (res.hasError())
			return res;

		return switch (ctx.op.getType()) {
			case EqnParser.ADD -> res;
			case EqnParser.SUB -> Neg.apply(res.value());
			default -> Res.error(
				"unsupported unary operator " + ctx.op.getText() + res.value());
		};
	}

	@Override
	public Res<Cell> visitMulDiv(MulDivContext ctx) {
		var a = visit(ctx.eqn(0));
		if (a.hasError())
			return a;
		var b = visit(ctx.eqn(1));
		if (b.hasError())
			return b;

		return switch (ctx.op.getType()) {
			case EqnParser.MUL -> Mul.apply(a.value(), b.value());
			case EqnParser.DIV -> Div.apply(a.value(), b.value());
			case EqnParser.MOD -> Mod.apply(a.value(), b.value());
			default -> Res.error(
				"operator not supported: " + a.value() + ctx.op.getText() + b.value());
		};
	}

	@Override
	public Res<Cell> visitComp(CompContext ctx) {
		var a = visit(ctx.eqn(0));
		if (a.hasError())
			return a;
		var b = visit(ctx.eqn(1));
		if (b.hasError())
			return b;

		var cellA = a.value();
		var cellB = b.value();
		if (!cellA.isNumCell() || !cellB.isNumCell())
			return Res.error("operator not supported: "
				+ cellA + ctx.op.getText() + cellB);

		double x = cellA.asNumCell().value();
		double y = cellB.asNumCell().value();
		return switch (ctx.op.getType()) {
			case EqnParser.EQ -> Res.of(Cell.of(x == y));
			case EqnParser.NEQ -> Res.of(Cell.of(x != y));
			case EqnParser.GE -> Res.of(Cell.of(x >= y));
			case EqnParser.GT -> Res.of(Cell.of(x > y));
			case EqnParser.LE -> Res.of(Cell.of(x <= y));
			case EqnParser.LT -> Res.of(Cell.of(x < y));
			default -> Res.error(
				"operator not supported: : " + cellA + ctx.op.getText() + cellB);
		};
	}

	@Override
	public Res<Cell> visitNot(NotContext ctx) {
		var cellRes = visit(ctx.eqn());
		if (cellRes.hasError()) return cellRes;

		var cell = cellRes.value();
		if (!cell.isBoolCell())
			return Res.error(
				"NOT operator requires boolean operand, got: " + cell);
		boolean value = cell.asBoolCell().value();
		return Res.of(Cell.of(!value));
	}

	@Override
	public Res<Cell> visitLogic(LogicContext ctx) {
		var a = visit(ctx.eqn(0));
		if (a.hasError())
			return a;
		var b = visit(ctx.eqn(1));
		if (b.hasError())
			return b;

		var cellA = a.value();
		var cellB = b.value();
		if (!cellA.isBoolCell() || !cellB.isBoolCell())
			return Res.error(
				"operator not supported: : " + cellA + ctx.op.getText() + cellB);

		boolean x = cellA.asBoolCell().value();
		boolean y = cellB.asBoolCell().value();
		return switch (ctx.op.getType()) {
			case EqnParser.AND -> Res.of(Cell.of(x && y));
			case EqnParser.OR -> Res.of(Cell.of(x || y));
			default -> Res.error(
				"operator not supported: : " + cellA + ctx.op.getText() + cellB);
		};
	}

	@Override
	public Res<Cell> visitIfThenElse(IfThenElseContext ctx) {
		var condRes = visit(ctx.eqn(0));
		if (condRes.hasError())
			return condRes;

		var cond = condRes.value();
		if (!cond.isBoolCell())
			return Res.error(
				"IF condition must be boolean, got: " + cond);

		return cond.asBoolCell().value()
			? visit(ctx.eqn(1))
			: visit(ctx.eqn(2));
	}

	@Override
	public Res<Cell> visitParens(ParensContext ctx) {
		return visit(ctx.eqn());
	}

	@Override
	public Res<Cell> visitPower(PowerContext ctx) {
		var a = visit(ctx.eqn(0));
		if (a.hasError())
			return a;
		var b = visit(ctx.eqn(1));
		if (b.hasError())
			return b;
		return Pow.apply(a.value(), b.value());
	}

	@Override
	public Res<Cell> visitNumber(NumberContext ctx) {
		try {
			var num = Double.parseDouble(ctx.getText());
			return Res.of(Cell.of(num));
		} catch (NumberFormatException e) {
			return Res.error("invalid number format: " + ctx.getText());
		}
	}

	@Override
	public Res<Cell> visitVar(VarContext ctx) {
		var v = evalCtx.getVar(Id.of(ctx.getText())).orElse(null);
		if (v == null)
			return Res.error("unknown variable: " + ctx.getText());
		return Res.of(v.cell());
	}
}
