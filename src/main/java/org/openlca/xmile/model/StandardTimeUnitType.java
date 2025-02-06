
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "standard_time_unit_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum StandardTimeUnitType {

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
    private final String value;

    StandardTimeUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StandardTimeUnitType fromValue(String v) {
        for (StandardTimeUnitType c: StandardTimeUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
