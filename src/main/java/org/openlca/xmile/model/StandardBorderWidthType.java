
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for standard_border_width_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="standard_border_width_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="thin"/&gt;
 *     &lt;enumeration value="thick"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "standard_border_width_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum StandardBorderWidthType {

    @XmlEnumValue("thin")
    THIN("thin"),
    @XmlEnumValue("thick")
    THICK("thick");
    private final String value;

    StandardBorderWidthType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StandardBorderWidthType fromValue(String v) {
        for (StandardBorderWidthType c: StandardBorderWidthType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
