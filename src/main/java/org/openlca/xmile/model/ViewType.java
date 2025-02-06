
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "view_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum ViewType {

    @XmlEnumValue("stock_flow")
    STOCK_FLOW("stock_flow"),
    @XmlEnumValue("interface")
    INTERFACE("interface"),
    @XmlEnumValue("popup")
    POPUP("popup");
    private final String value;

    ViewType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewType fromValue(String v) {
        for (ViewType c: ViewType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
