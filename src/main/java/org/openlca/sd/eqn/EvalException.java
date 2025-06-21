package org.openlca.sd.eqn;

public class EvalException extends RuntimeException {

	private EvalException(String message) {
		super(message);
	}

	static EvalException of(String message) {
		return new EvalException(message);
	}

	static EvalException unsupported(String op, Cell a, Cell b) {
		return of("unsupported operator: " + a + " " + op + " " + b);
	}

}
