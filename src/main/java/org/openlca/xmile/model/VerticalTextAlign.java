
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "vertical_text_align", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum VerticalTextAlign {

    @XmlEnumValue("top")
    TOP("top"),
    @XmlEnumValue("bottom")
    BOTTOM("bottom"),
    @XmlEnumValue("center")
    CENTER("center");
    private final String value;

    VerticalTextAlign(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VerticalTextAlign fromValue(String v) {
        for (VerticalTextAlign c: VerticalTextAlign.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
