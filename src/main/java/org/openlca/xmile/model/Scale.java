
package org.openlca.xmile.model;

import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "scale", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Scale {

    @XmlAttribute(name = "min")
    protected Double min;
    @XmlAttribute(name = "max")
    protected Double max;
    @XmlAttribute(name = "auto")
    protected Boolean auto;
    @XmlAttribute(name = "group")
    protected BigInteger group;

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

    /**
     * Gets the value of the auto property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isAuto() {
        return auto;
    }

    /**
     * Sets the value of the auto property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAuto(Boolean value) {
        this.auto = value;
    }

    /**
     * Gets the value of the group property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setGroup(BigInteger value) {
        this.group = value;
    }

}
