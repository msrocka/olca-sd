
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transparency_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="transparency_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="opaque"/&gt;
 *     &lt;enumeration value="transparent"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
