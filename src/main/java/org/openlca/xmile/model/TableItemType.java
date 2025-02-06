
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for table_item_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="table_item_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="variable"/&gt;
 *     &lt;enumeration value="space"/&gt;
 *     &lt;enumeration value="time"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "table_item_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum TableItemType {

    @XmlEnumValue("variable")
    VARIABLE("variable"),
    @XmlEnumValue("space")
    SPACE("space"),
    @XmlEnumValue("time")
    TIME("time");
    private final String value;

    TableItemType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TableItemType fromValue(String v) {
        for (TableItemType c: TableItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
