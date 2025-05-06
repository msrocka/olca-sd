package org.openlca.sd.eqns;

import java.util.Objects;

public record Dimension(String name, Element[] elements) {

	public Dimension {
		Objects.requireNonNull(name);
		Objects.requireNonNull(elements);
	}

	public int size() {
		return elements.length;
	}

	public int indexOf(String elem) {
		for (int i = 0; i < elements.length; i++) {
			var e = elements[i];
			if (e.name.equals(elem)) {
				return i;
			}
		}
		return -1;
	}

	public record Element(String name) {
		public Element {
			Objects.requireNonNull(name);
		}
	}
}
