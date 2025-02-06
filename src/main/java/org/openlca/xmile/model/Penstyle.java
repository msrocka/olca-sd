
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "penstyle", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum Penstyle {

    @XmlEnumValue("solid")
    SOLID("solid"),
    @XmlEnumValue("dotted")
    DOTTED("dotted"),
    @XmlEnumValue("dashed")
    DASHED("dashed"),
    @XmlEnumValue("dot_dashed")
    DOT_DASHED("dot_dashed");
    private final String value;

    Penstyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Penstyle fromValue(String v) {
        for (Penstyle c: Penstyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
