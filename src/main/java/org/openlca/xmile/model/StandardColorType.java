
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

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
