package org.openlca.xmile.model2;

import java.util.Optional;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum StandardTimeUnit {

	@XmlEnumValue("day")
	DAY("day"),

	@XmlEnumValue("hour")
	HOUR("hour"),

	@XmlEnumValue("microsecond")
	MICROSECOND("microsecond"),

	@XmlEnumValue("millisecond")
	MILLISECOND("millisecond"),

	@XmlEnumValue("minute")
	MINUTE("minute"),

	@XmlEnumValue("month")
	MONTH("month"),

	@XmlEnumValue("nanosecond")
	NANOSECOND("nanosecond"),

	@XmlEnumValue("quarter")
	QUARTER("quarter"),

	@XmlEnumValue("second")
	SECOND("second"),

	@XmlEnumValue("week")
	WEEK("week"),

	@XmlEnumValue("year")
	YEAR("year");

	private final String id;

	StandardTimeUnit(String id) {
		this.id = id;
	}

	public static Optional<StandardTimeUnit> fromString(String s) {
		if (s == null)
			return Optional.empty();
		var id = s.trim().toLowerCase();
		for (StandardTimeUnit unit : values()) {
			if (unit.id.equals(id)) {
				return Optional.of(unit);
			}
		}
		return Optional.empty();
	}

	public String id() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

}
