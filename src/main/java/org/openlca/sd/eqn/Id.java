package org.openlca.sd.eqn;

class Id {

	private Id() {
	}

	static boolean isNil(String s) {
		return s == null || s.isBlank();
	}

	static String of(String s) {
		if (isNil(s))
			return "nil";
		return s.strip()
			.replaceAll("\\s", "_")
			.toLowerCase();
	}
}
