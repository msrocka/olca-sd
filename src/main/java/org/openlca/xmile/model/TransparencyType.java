
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "transparency_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum TransparencyType {

    @XmlEnumValue("opaque")
    OPAQUE("opaque"),
    @XmlEnumValue("transparent")
    TRANSPARENT("transparent");
    private final String value;

    TransparencyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransparencyType fromValue(String v) {
        for (TransparencyType c: TransparencyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
