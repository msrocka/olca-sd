
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "report_flows", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum ReportFlows {

    @XmlEnumValue("instantaneous")
    INSTANTANEOUS("instantaneous"),
    @XmlEnumValue("summed")
    SUMMED("summed");
    private final String value;

    ReportFlows(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReportFlows fromValue(String v) {
        for (ReportFlows c: ReportFlows.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
