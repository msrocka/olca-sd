
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "orientation", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum Orientation {

    @XmlEnumValue("horizontal")
    HORIZONTAL("horizontal"),
    @XmlEnumValue("vertical")
    VERTICAL("vertical");
    private final String value;

    Orientation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Orientation fromValue(String v) {
        for (Orientation c: Orientation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
