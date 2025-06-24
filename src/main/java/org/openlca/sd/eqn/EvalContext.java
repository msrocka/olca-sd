package org.openlca.sd.eqn;

import java.util.HashMap;
import java.util.Map;

public class EvalContext {

	private final Map<String, Cell> vars = new HashMap<>();

	public EvalContext bind(String v, Cell value) {
		vars.put(v, value);
		return this;
	}

	public EvalContext bind(String v, double value) {
		return bind(v, Cell.of(value));
	}

	public Cell get(String v) {
		return vars.getOrDefault(v, Cell.empty());
	}
}
