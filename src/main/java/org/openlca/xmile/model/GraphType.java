
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for graph_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="graph_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="time_series"/&gt;
 *     &lt;enumeration value="scatter"/&gt;
 *     &lt;enumeration value="bar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
