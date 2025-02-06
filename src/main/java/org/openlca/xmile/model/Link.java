
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}double" default="0" /&gt;
 *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}double" default="0" /&gt;
 *       &lt;attribute name="zoom" type="{http://www.w3.org/2001/XMLSchema}double" default="100" /&gt;
 *       &lt;attribute name="effect" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="dissolve"/&gt;
 *             &lt;enumeration value="checkerboard"/&gt;
 *             &lt;enumeration value="bars"/&gt;
 *             &lt;enumeration value="wipe_left"/&gt;
 *             &lt;enumeration value="wipe_right"/&gt;
 *             &lt;enumeration value="wipe_top"/&gt;
 *             &lt;enumeration value="wipe_bottom"/&gt;
 *             &lt;enumeration value="wipe_clockwise"/&gt;
 *             &lt;enumeration value="wipe_counterclockwise"/&gt;
 *             &lt;enumeration value="iris_in"/&gt;
 *             &lt;enumeration value="iris_out"/&gt;
 *             &lt;enumeration value="doors_close"/&gt;
 *             &lt;enumeration value="doors_open"/&gt;
 *             &lt;enumeration value="venetian_left"/&gt;
 *             &lt;enumeration value="venetian_right"/&gt;
 *             &lt;enumeration value="venetian_top"/&gt;
 *             &lt;enumeration value="venetian_bottom"/&gt;
 *             &lt;enumeration value="push_bottom"/&gt;
 *             &lt;enumeration value="push_top"/&gt;
 *             &lt;enumeration value="push_left"/&gt;
 *             &lt;enumeration value="push_right"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="to_black" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
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
