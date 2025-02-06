
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

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
