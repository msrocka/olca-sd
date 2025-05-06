package org.openlca.sd.eqn;

class Util {

	private Util() {
	}

	static boolean isEmpty(String str) {
		return str == null || str.isBlank();
	}

	static boolean isMatchAll(String s) {
		return s != null && s.strip().equals("*");
	}
}
