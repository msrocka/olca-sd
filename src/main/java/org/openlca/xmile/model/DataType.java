
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "data_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum DataType {

    CSV,
    XLS,
    XML;

    public String value() {
        return name();
    }

    public static DataType fromValue(String v) {
        return valueOf(v);
    }

}
