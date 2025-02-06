
package org.openlca.xmile.model;


import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "stacked_container", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class StackedContainer
    extends ViewContentType
{

    @XmlAttribute(name = "x")
    protected Double x;
    @XmlAttribute(name = "y")
    protected Double y;
    @XmlAttribute(name = "uid")
    protected Integer uid;
    @XmlAttribute(name = "visible_index")
    protected BigInteger visibleIndex;

    /**
     * Gets the value of the x property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setX(Double value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setY(Double value) {
        this.y = value;
    }

    /**
     * Gets the value of the uid property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setUid(Integer value) {
        this.uid = value;
    }

    /**
     * Gets the value of the visibleIndex property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVisibleIndex() {
        return visibleIndex;
    }

    /**
     * Sets the value of the visibleIndex property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVisibleIndex(BigInteger value) {
        this.visibleIndex = value;
    }

}
