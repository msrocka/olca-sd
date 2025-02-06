
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="xscale" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}min_max_type" minOccurs="0"/&gt;
 *         &lt;element name="yscale" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}min_max_type" minOccurs="0"/&gt;
 *         &lt;element name="xpts" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}points_type" minOccurs="0"/&gt;
 *         &lt;element name="ypts" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}points_type"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="type" default="continuous"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="continuous"/&gt;
 *             &lt;enumeration value="extrapolate"/&gt;
 *             &lt;enumeration value="discrete"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "gf", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Gf {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected MinMaxType xscale;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected MinMaxType yscale;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected PointsType xpts;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected PointsType ypts;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the xscale property.
     * 
     * @return
     *     possible object is
     *     {@link MinMaxType }
     *     
     */
    public MinMaxType getXscale() {
        return xscale;
    }

    /**
     * Sets the value of the xscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinMaxType }
     *     
     */
    public void setXscale(MinMaxType value) {
        this.xscale = value;
    }

    /**
     * Gets the value of the yscale property.
     * 
     * @return
     *     possible object is
     *     {@link MinMaxType }
     *     
     */
    public MinMaxType getYscale() {
        return yscale;
    }

    /**
     * Sets the value of the yscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinMaxType }
     *     
     */
    public void setYscale(MinMaxType value) {
        this.yscale = value;
    }

    /**
     * Gets the value of the xpts property.
     * 
     * @return
     *     possible object is
     *     {@link PointsType }
     *     
     */
    public PointsType getXpts() {
        return xpts;
    }

    /**
     * Sets the value of the xpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointsType }
     *     
     */
    public void setXpts(PointsType value) {
        this.xpts = value;
    }

    /**
     * Gets the value of the ypts property.
     * 
     * @return
     *     possible object is
     *     {@link PointsType }
     *     
     */
    public PointsType getYpts() {
        return ypts;
    }

    /**
     * Sets the value of the ypts property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointsType }
     *     
     */
    public void setYpts(PointsType value) {
        this.ypts = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "continuous";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
