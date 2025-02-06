
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
@XmlRootElement(name = "link", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Link {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "x")
    protected Double x;
    @XmlAttribute(name = "y")
    protected Double y;
    @XmlAttribute(name = "zoom")
    protected Double zoom;
    @XmlAttribute(name = "effect")
    protected String effect;
    @XmlAttribute(name = "to_black")
    protected Boolean toBlack;
    @XmlAttribute(name = "target", required = true)
    protected String target;

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
     * Gets the value of the x property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public double getX() {
        if (x == null) {
            return  0.0D;
        } else {
            return x;
        }
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
    public double getY() {
        if (y == null) {
            return  0.0D;
        } else {
            return y;
        }
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
     * Gets the value of the zoom property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public double getZoom() {
        if (zoom == null) {
            return  100.0D;
        } else {
            return zoom;
        }
    }

    /**
     * Sets the value of the zoom property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setZoom(Double value) {
        this.zoom = value;
    }

    /**
     * Gets the value of the effect property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEffect() {
        if (effect == null) {
            return "none";
        } else {
            return effect;
        }
    }

    /**
     * Sets the value of the effect property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEffect(String value) {
        this.effect = value;
    }

    /**
     * Gets the value of the toBlack property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isToBlack() {
        if (toBlack == null) {
            return false;
        } else {
            return toBlack;
        }
    }

    /**
     * Sets the value of the toBlack property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setToBlack(Boolean value) {
        this.toBlack = value;
    }

    /**
     * Gets the value of the target property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTarget(String value) {
        this.target = value;
    }

}
