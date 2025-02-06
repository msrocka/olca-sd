
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "min_max_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class MinMaxType {

    @XmlAttribute(name = "min")
    protected Double min;
    @XmlAttribute(name = "max")
    protected Double max;

    /**
     * Gets the value of the min property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setMin(Double value) {
        this.min = value;
    }

    /**
     * Gets the value of the max property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setMax(Double value) {
        this.max = value;
    }

}
