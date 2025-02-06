
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "plot", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Plot {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected Plot.Entity entity;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Scale scale;
    @XmlAttribute(name = "index")
    protected Integer index;
    @XmlAttribute(name = "pen_width")
    protected Integer penWidth;
    @XmlAttribute(name = "pen_style")
    protected Penstyle penStyle;
    @XmlAttribute(name = "show_y_axis")
    protected Boolean showYAxis;
    @XmlAttribute(name = "title", required = true)
    protected String title;
    @XmlAttribute(name = "right_axis")
    protected Boolean rightAxis;

    /**
     * Gets the value of the entity property.
     *
     * @return
     *     possible object is
     *     {@link Entity }
     *
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     *
     * @param value
     *     allowed object is
     *     {@link Entity }
     *
     */
    public void setEntity(Entity value) {
        this.entity = value;
    }

    /**
     * Gets the value of the scale property.
     *
     * @return
     *     possible object is
     *     {@link Scale }
     *
     */
    public Scale getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     *
     * @param value
     *     allowed object is
     *     {@link Scale }
     *
     */
    public void setScale(Scale value) {
        this.scale = value;
    }

    /**
     * Gets the value of the index property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setIndex(Integer value) {
        this.index = value;
    }

    /**
     * Gets the value of the penWidth property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public int getPenWidth() {
        if (penWidth == null) {
            return  1;
        } else {
            return penWidth;
        }
    }

    /**
     * Sets the value of the penWidth property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPenWidth(Integer value) {
        this.penWidth = value;
    }

    /**
     * Gets the value of the penStyle property.
     *
     * @return
     *     possible object is
     *     {@link Penstyle }
     *
     */
    public Penstyle getPenStyle() {
        if (penStyle == null) {
            return Penstyle.SOLID;
        } else {
            return penStyle;
        }
    }

    /**
     * Sets the value of the penStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link Penstyle }
     *
     */
    public void setPenStyle(Penstyle value) {
        this.penStyle = value;
    }

    /**
     * Gets the value of the showYAxis property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isShowYAxis() {
        if (showYAxis == null) {
            return true;
        } else {
            return showYAxis;
        }
    }

    /**
     * Sets the value of the showYAxis property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setShowYAxis(Boolean value) {
        this.showYAxis = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the rightAxis property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isRightAxis() {
        if (rightAxis == null) {
            return false;
        } else {
            return rightAxis;
        }
    }

    /**
     * Sets the value of the rightAxis property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRightAxis(Boolean value) {
        this.rightAxis = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Entity {

        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "index")
        protected String index;

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
         * Gets the value of the index property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIndex() {
            return index;
        }

        /**
         * Sets the value of the index property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIndex(String value) {
            this.index = value;
        }

    }

}
