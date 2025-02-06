
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for report_balances.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="report_balances"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="beginning"/&gt;
 *     &lt;enumeration value="ending"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "report_balances", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum ReportBalances {

    @XmlEnumValue("beginning")
    BEGINNING("beginning"),
    @XmlEnumValue("ending")
    ENDING("ending");
    private final String value;

    ReportBalances(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReportBalances fromValue(String v) {
        for (ReportBalances c: ReportBalances.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
