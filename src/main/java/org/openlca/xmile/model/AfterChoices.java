
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for after_choices.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="after_choices"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="one_time"/&gt;
 *     &lt;enumeration value="one_dt"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "after_choices", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
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
