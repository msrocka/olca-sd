package org.openlca.sd.eqn;

import org.openlca.sd.eqn.generated.EqnBaseVisitor;
import org.openlca.sd.eqn.generated.EqnParser;
import org.openlca.sd.eqn.generated.EqnParser.AddSubContext;
import org.openlca.sd.eqn.generated.EqnParser.NumberContext;

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
	public Cell visitNumber(NumberContext ctx) {
		var num = Double.parseDouble(ctx.getText());
		return Cell.of(num);
	}

}
