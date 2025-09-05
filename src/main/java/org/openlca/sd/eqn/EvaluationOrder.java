package org.openlca.sd.eqn;

import java.util.HashSet;
import java.util.Set;

import org.openlca.sd.eqn.Cell.EqnCell;
import org.openlca.sd.eqn.Cell.LookupCell;
import org.openlca.sd.eqn.Cell.TensorCell;

public class EvaluationOrder {

	/// Returns the evaluation dependencies of the given var. The variables
	/// with the given IDs must be evaluated before the given variable.
	public static Set<Id> dependenciesOf(Var var) {
		if (var == null)
			return Set.of();
		var ids = new HashSet<Id>();
		fillDeps(var.cell(), ids);
		return ids;
	}

	private static void fillDeps(Cell cell, Set<Id> ids) {

		if (cell instanceof EqnCell(String eqn)) {
			var vars = Interpreter.varsOf(eqn);
			if (!vars.hasError()) {
				ids.addAll(vars.value());
			}
			return;
		}

		if (cell instanceof LookupCell(String eqn, LookupFunc ignored)) {
			var vars = Interpreter.varsOf(eqn);
			if (!vars.hasError()) {
				ids.addAll(vars.value());
			}
			return;
		}

		if (cell instanceof TensorCell(Tensor t)) {
			for (int i = 0; i < t.size(); i++) {
				fillDeps(t.get(i), ids);
			}
		}
	}

	private static class Sorter {



	}


}
