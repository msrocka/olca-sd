package org.openlca.xmile.model2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum StandardMethod {

	@XmlEnumValue("euler")
	EULER("euler"),

	@XmlEnumValue("rk2")
	RK2("rk2"),

	@XmlEnumValue("rk2_auto")
	RK2_AUTO("rk2_auto"),

	@XmlEnumValue("rk4")
	RK4("rk4"),

	@XmlEnumValue("rk4_auto")
	RK4_AUTO("rk4_auto");

	private final String id;

	StandardMethod(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}

	public static StandardMethod fromString(String s) {
		if (s == null)
			return null;
		var id = s.trim().toLowerCase();
		for (StandardMethod method : values()) {
			if (method.id.equals(id)) {
				return method;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return id;
	}

}
