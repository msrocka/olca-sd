package org.openlca.sd.eqn;

import java.util.Objects;

public record Dimension(String name, String[] elements) {

	public Dimension {
		Objects.requireNonNull(name);
		Objects.requireNonNull(elements);
	}

	public static Dimension of(String name, String... elements) {
		return new Dimension(name, elements);
	}

	public int size() {
		return elements.length;
	}

	public int indexOf(String elem) {
		if (Util.isEmpty(elem))
			return -1;
		for (int i = 0; i < elements.length; i++) {
			if (elem.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dimension(String oName, String[] oElems)))
			return false;
		if (!Objects.equals(name, oName))
			return false;
		if (elements.length != oElems.length)
			return false;
		for (int i = 0; i < elements.length; i++) {
			if (!Objects.equals(elements[i], oElems[i]))
				return false;
		}
		return true;
	}
}
