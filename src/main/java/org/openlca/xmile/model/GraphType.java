
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "graph_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum GraphType {

    @XmlEnumValue("time_series")
    TIME_SERIES("time_series"),
    @XmlEnumValue("scatter")
    SCATTER("scatter"),
    @XmlEnumValue("bar")
    BAR("bar");
    private final String value;

    GraphType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GraphType fromValue(String v) {
        for (GraphType c: GraphType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
