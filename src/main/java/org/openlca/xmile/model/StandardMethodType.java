
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "standard_method_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum StandardMethodType {

    @XmlEnumValue("euler")
    EULER("euler"),
    @XmlEnumValue("rk2")
    RK_2("rk2"),
    @XmlEnumValue("rk2_auto")
    RK_2_AUTO("rk2_auto"),
    @XmlEnumValue("rk4")
    RK_4("rk4"),
    @XmlEnumValue("rk4_auto")
    RK_4_AUTO("rk4_auto");
    private final String value;

    StandardMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StandardMethodType fromValue(String v) {
        for (StandardMethodType c: StandardMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
