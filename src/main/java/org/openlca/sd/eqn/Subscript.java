package org.openlca.sd.eqn;

public sealed interface Subscript {

	static Subscript parse(String s) {
		if (Id.isNil(s))
			return Empty.instance;
		var t = s.strip();

		if ("*".equals(t))
			return Wildcard.instance;

		if (Character.isDigit(t.charAt(0))) {
			try {
				int idx = Integer.parseInt(t);
				return new Index(idx - 1);
			} catch (Exception ignored) {
			}
		}

		return new Identifier(Id.of(t));
	}

	record Index(int value) implements Subscript {
	}

	record Identifier(String value) implements Subscript {
	}

	record Wildcard() implements Subscript {
		private static final Wildcard instance = new Wildcard();
	}

	record Empty() implements Subscript {
		private static final Empty instance = new Empty();
	}
}
