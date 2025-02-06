
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "frequency_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum FrequencyType {

    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),
    @XmlEnumValue("on_demand")
    ON_DEMAND("on_demand");
    private final String value;

    FrequencyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FrequencyType fromValue(String v) {
        for (FrequencyType c: FrequencyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
