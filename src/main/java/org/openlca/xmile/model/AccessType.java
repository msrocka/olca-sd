
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AccessType {

	@XmlEnumValue("input")
	INPUT("input"),

	@XmlEnumValue("output")
	OUTPUT("output");
	private final String value;

	AccessType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static AccessType fromValue(String v) {
		for (AccessType c : AccessType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
