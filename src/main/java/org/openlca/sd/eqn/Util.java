package org.openlca.sd.eqn;

import java.util.HashSet;

import org.openlca.sd.eqn.Cell.EqnCell;
import org.openlca.sd.eqn.Cell.LookupCell;
import org.openlca.sd.eqn.Cell.TensorCell;

class Util {

	private Util() {
	}

	static boolean isEmpty(String str) {
		return str == null || str.isBlank();
	}

	static void fillDependencies(Cell cell, HashSet<Id> ids) {

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
				fillDependencies(t.get(i), ids);
			}
		}
	}
}
