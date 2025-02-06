
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for penstyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="penstyle"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="solid"/&gt;
 *     &lt;enumeration value="dotted"/&gt;
 *     &lt;enumeration value="dashed"/&gt;
 *     &lt;enumeration value="dot_dashed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
