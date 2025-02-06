
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orientation_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="orientation_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="vertical"/&gt;
 *     &lt;enumeration value="horizontal"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "orientation_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum OrientationType {

    @XmlEnumValue("vertical")
    VERTICAL("vertical"),
    @XmlEnumValue("horizontal")
    HORIZONTAL("horizontal");
    private final String value;

    OrientationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrientationType fromValue(String v) {
        for (OrientationType c: OrientationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
