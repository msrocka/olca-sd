package org.openlca.sd.eqn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public sealed interface Var {

	Id name();

	Cell cell();

	default Set<Id> dependencies() {
		var ids = new HashSet<Id>();
		Util.fillDependencies(cell(), ids);
		return ids;
	}

	record Aux(Id name, Cell cell) implements Var {
	}

	record Rate(Id name, Cell cell) implements Var {
	}

	record Stock(
		Id name, Cell cell, List<Id> inFlows, List<Id> outFlows
	) implements Var {

		@Override
		public Set<Id> dependencies() {
			var ids = Var.super.dependencies();
			if (inFlows != null) {
				ids.addAll(inFlows);
			}
			if (outFlows != null) {
				ids.addAll(outFlows);
			}
			return ids;
		}
	}
}
