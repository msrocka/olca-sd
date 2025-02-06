
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

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
