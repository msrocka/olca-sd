package org.openlca.sd.eqn;

import java.util.HashMap;
import java.util.Map;

public class EvalContext {

	private final Map<String, Cell> vars = new HashMap<>();

	public EvalContext bind(String v, Cell value) {
		vars.put(norm(v), value);
		return this;
	}

	public EvalContext bind(String v, double value) {
		return bind(v, Cell.of(value));
	}

	public Cell get(String v) {
		return vars.getOrDefault(norm(v), Cell.empty());
	}

	private String norm(String v) {
		return v != null
			? v.trim().toLowerCase()
			: "";
	}
}
