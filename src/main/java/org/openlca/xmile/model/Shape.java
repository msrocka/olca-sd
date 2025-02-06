
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "shape", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Shape {

    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "width")
    @XmlSchemaType(name = "anySimpleType")
    protected String width;
    @XmlAttribute(name = "height")
    @XmlSchemaType(name = "anySimpleType")
    protected String height;
    @XmlAttribute(name = "radius")
    @XmlSchemaType(name = "anySimpleType")
    protected String radius;

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
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

    /**
     * Gets the value of the width property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Gets the value of the radius property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRadius(String value) {
        this.radius = value;
    }

}
