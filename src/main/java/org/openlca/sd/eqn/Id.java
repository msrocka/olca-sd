package org.openlca.sd.eqn;

public class Id {

	private static final Id NIL = new Id("*nil*", "");
	private final String label;
	private final String value;

	private Id(String label, String value) {
		this.label = label;
		this.value = value;
	}

	static Id of(String s) {
		if (isNil(s))
			return NIL;
		var value = s.strip()
			.replaceAll("\\s", "_")
			.toLowerCase();
		return new Id(s, value);
	}

	static Id[] ofAll(String... ss) {
		if (ss == null || ss.length == 0)
			return new Id[0];
		var ids = new Id[ss.length];
		for (int i = 0; i < ss.length; i++) {
			ids[i] = of(ss[i]);
		}
		return ids;
	}

	static boolean isNil(String s) {
		return s == null || s.isBlank();
	}

	public boolean isNil() {
		return this == NIL;
	}

	public String label() {
		return label;
	}

	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return obj instanceof Id other && value.equals(other.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean matches(String s) {
		return equals(Id.of(s));
	}

}
