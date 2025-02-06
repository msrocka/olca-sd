
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AfterChoices {

    @XmlEnumValue("one_time")
    ONE_TIME("one_time"),
    @XmlEnumValue("one_dt")
    ONE_DT("one_dt");
    private final String value;

    AfterChoices(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AfterChoices fromValue(String v) {
        for (AfterChoices c: AfterChoices.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
