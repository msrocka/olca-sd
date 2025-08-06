package org.openlca.sd.eqn;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openlca.sd.eqn.func.Func;

public class EvalContext {

	private final Map<Id, Var> vars = new HashMap<>();
	private final Map<Id, Func> funcs = new HashMap<>();

	public EvalContext bind(Var var) {
		if (var != null) {
			vars.put(var.name(), var);
		}
		return this;
	}

	public Optional<Var> getVar(Id name) {
		return name != null
			? Optional.ofNullable(vars.get(name))
			: Optional.empty();
	}

	public EvalContext bind(Id name, Func func) {
		if (name != null && func != null) {
			funcs.put(name, func);
		}
		return this;
	}

	public Optional<Func> getFunc(Id name) {
		return name != null
			? Optional.ofNullable(funcs.get(name))
			: Optional.empty();
	}

}
