
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "orientation_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum OrientationType {

    @XmlEnumValue("vertical")
    VERTICAL("vertical"),
    @XmlEnumValue("horizontal")
    HORIZONTAL("horizontal");
    private final String value;

    OrientationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrientationType fromValue(String v) {
        for (OrientationType c: OrientationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
