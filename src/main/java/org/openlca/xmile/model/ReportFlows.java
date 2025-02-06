
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for report_flows.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="report_flows"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="instantaneous"/&gt;
 *     &lt;enumeration value="summed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
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
