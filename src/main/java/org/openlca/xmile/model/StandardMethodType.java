
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for standard_method_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="standard_method_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="euler"/&gt;
 *     &lt;enumeration value="rk2"/&gt;
 *     &lt;enumeration value="rk2_auto"/&gt;
 *     &lt;enumeration value="rk4"/&gt;
 *     &lt;enumeration value="rk4_auto"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
