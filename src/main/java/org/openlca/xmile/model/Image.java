
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
@XmlRootElement(name = "image", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Image {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "resource")
    protected String resource;
    @XmlAttribute(name = "size_to_parent")
    protected Boolean sizeToParent;
    @XmlAttribute(name = "width")
    protected Integer width;
    @XmlAttribute(name = "height")
    protected Integer height;

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
     * Gets the value of the resource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResource(String value) {
        this.resource = value;
    }

    /**
     * Gets the value of the sizeToParent property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isSizeToParent() {
        if (sizeToParent == null) {
            return false;
        } else {
            return sizeToParent;
        }
    }

    /**
     * Sets the value of the sizeToParent property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSizeToParent(Boolean value) {
        this.sizeToParent = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setWidth(Integer value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setHeight(Integer value) {
        this.height = value;
    }

}
