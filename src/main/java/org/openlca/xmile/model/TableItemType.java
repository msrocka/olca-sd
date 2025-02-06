
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

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
