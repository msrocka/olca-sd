
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "reset_to", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class ResetTo {

    @XmlValue
    protected double value;
    @XmlAttribute(name = "after")
    protected AfterChoices after;

    /**
     * Gets the value of the value property.
     *
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the value of the after property.
     *
     * @return
     *     possible object is
     *     {@link AfterChoices }
     *
     */
    public AfterChoices getAfter() {
        return after;
    }

    /**
     * Sets the value of the after property.
     *
     * @param value
     *     allowed object is
     *     {@link AfterChoices }
     *
     */
    public void setAfter(AfterChoices value) {
        this.after = value;
    }

}
