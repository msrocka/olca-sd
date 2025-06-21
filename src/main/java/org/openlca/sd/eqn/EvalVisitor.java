package org.openlca.sd.eqn;

import org.openlca.sd.eqn.EqnParser.AddSubContext;
import org.openlca.sd.eqn.EqnParser.NumberContext;

class EvalVisitor extends org.openlca.sd.eqn.EqnBaseVisitor<Cell> {

	@Override
	public Cell visitAddSub(AddSubContext ctx) {
		var a = visit(ctx.eqn(0));
		var b = visit(ctx.eqn(1));

		return CellOps.add(a, b);
	}

	@Override
	public Cell visitNumber(NumberContext ctx) {
		var num = Double.parseDouble(ctx.getText());
		return Cell.of(num);
	}

}
