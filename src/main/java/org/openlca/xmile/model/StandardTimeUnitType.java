
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for standard_time_unit_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="standard_time_unit_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="day"/&gt;
 *     &lt;enumeration value="hour"/&gt;
 *     &lt;enumeration value="microsecond"/&gt;
 *     &lt;enumeration value="millisecond"/&gt;
 *     &lt;enumeration value="minute"/&gt;
 *     &lt;enumeration value="month"/&gt;
 *     &lt;enumeration value="nanosecond"/&gt;
 *     &lt;enumeration value="quarter"/&gt;
 *     &lt;enumeration value="second"/&gt;
 *     &lt;enumeration value="week"/&gt;
 *     &lt;enumeration value="year"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
