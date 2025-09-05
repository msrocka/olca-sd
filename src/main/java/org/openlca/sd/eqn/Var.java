package org.openlca.sd.eqn;

import java.util.List;

public sealed interface Var {

	Id name();

	Cell cell();

	record Aux(Id name, Cell cell) implements Var {
	}

	record Rate(Id name, Cell cell) implements Var {
	}

	record Stock(
		Id name, Cell cell, List<Id> inFlows, List<Id> outFlows
	) implements Var {
	}
}
