package org.openlca.sd.eqn;

import java.util.List;

public sealed interface Var {

	String id();

	Cell cell();

	record Aux(String id, Cell cell) implements Var {
	}

	record Rate(String id, Cell cell) implements Var {
	}

	record Stock(
		String id,
		Cell cell,
		List<String> inFlows,
		List<String> outFlows
	) implements Var {
	}
}
