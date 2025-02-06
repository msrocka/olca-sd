
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "points_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", propOrder = {
    "value"
})
public class PointsType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "sep")
    protected String sep;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the sep property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSep() {
        if (sep == null) {
            return ",";
        } else {
            return sep;
        }
    }

    /**
     * Sets the value of the sep property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSep(String value) {
        this.sep = value;
    }

}
