
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for view_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="view_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="stock_flow"/&gt;
 *     &lt;enumeration value="interface"/&gt;
 *     &lt;enumeration value="popup"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
