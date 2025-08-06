package org.openlca.sd.eqn;

import java.util.List;

public sealed interface Var {

	Id id();

	Cell cell();

	record Aux(Id id, Cell cell) implements Var {
	}

	record Rate(Id id, Cell cell) implements Var {
	}

	record Stock(
		Id id, Cell cell, List<Id> inFlows, List<Id> outFlows
	) implements Var {
	}
}
