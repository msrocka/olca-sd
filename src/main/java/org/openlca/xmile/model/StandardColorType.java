
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for standard_color_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="standard_color_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="aqua"/&gt;
 *     &lt;enumeration value="black"/&gt;
 *     &lt;enumeration value="blue"/&gt;
 *     &lt;enumeration value="fuchsia"/&gt;
 *     &lt;enumeration value="gray"/&gt;
 *     &lt;enumeration value="green"/&gt;
 *     &lt;enumeration value="lime"/&gt;
 *     &lt;enumeration value="maroon"/&gt;
 *     &lt;enumeration value="navy"/&gt;
 *     &lt;enumeration value="olive"/&gt;
 *     &lt;enumeration value="purple"/&gt;
 *     &lt;enumeration value="red"/&gt;
 *     &lt;enumeration value="silver"/&gt;
 *     &lt;enumeration value="teal"/&gt;
 *     &lt;enumeration value="white"/&gt;
 *     &lt;enumeration value="yellow"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "standard_color_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum StandardColorType {

    @XmlEnumValue("aqua")
    AQUA("aqua"),
    @XmlEnumValue("black")
    BLACK("black"),
    @XmlEnumValue("blue")
    BLUE("blue"),
    @XmlEnumValue("fuchsia")
    FUCHSIA("fuchsia"),
    @XmlEnumValue("gray")
    GRAY("gray"),
    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("lime")
    LIME("lime"),
    @XmlEnumValue("maroon")
    MAROON("maroon"),
    @XmlEnumValue("navy")
    NAVY("navy"),
    @XmlEnumValue("olive")
    OLIVE("olive"),
    @XmlEnumValue("purple")
    PURPLE("purple"),
    @XmlEnumValue("red")
    RED("red"),
    @XmlEnumValue("silver")
    SILVER("silver"),
    @XmlEnumValue("teal")
    TEAL("teal"),
    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("yellow")
    YELLOW("yellow");
    private final String value;

    StandardColorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StandardColorType fromValue(String v) {
        for (StandardColorType c: StandardColorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
