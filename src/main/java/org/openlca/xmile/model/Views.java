
package org.openlca.xmile.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}style" minOccurs="0"/&gt;
 *         &lt;element name="view" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}view_content_type"&gt;
 *                 &lt;attribute name="background" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="zoom" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="scroll_x" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="scroll_y" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="home_page" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *                 &lt;attribute name="home_view" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *                 &lt;attribute name="page_width" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="page_height" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="show_pages" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *                 &lt;attribute name="page_orientation"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="landscape"/&gt;
 *                       &lt;enumeration value="portrait"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="page_sequence"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="row"/&gt;
 *                       &lt;enumeration value="column"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="type" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}view_type" default="stock_flow" /&gt;
 *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *                 &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "styleOrView"
})
@XmlRootElement(name = "views", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Views {

    @XmlElements({
        @XmlElement(name = "style", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Style.class),
        @XmlElement(name = "view", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = View.class)
    })
    protected List<Object> styleOrView;

    /**
     * Gets the value of the styleOrView property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleOrView property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleOrView().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Style }
     * {@link View }
     *
     *
     */
    public List<Object> getStyleOrView() {
        if (styleOrView == null) {
            styleOrView = new ArrayList<Object>();
        }
        return this.styleOrView;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}view_content_type"&gt;
     *       &lt;attribute name="background" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="zoom" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="scroll_x" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="scroll_y" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="home_page" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *       &lt;attribute name="home_view" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="page_width" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="page_height" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="show_pages" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="page_orientation"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="landscape"/&gt;
     *             &lt;enumeration value="portrait"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="page_sequence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="row"/&gt;
     *             &lt;enumeration value="column"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="type" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}view_type" default="stock_flow" /&gt;
     *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
     *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
     *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class View
        extends ViewContentType
    {

        @XmlAttribute(name = "background")
        protected String background;
        @XmlAttribute(name = "zoom")
        protected Double zoom;
        @XmlAttribute(name = "scroll_x")
        protected Double scrollX;
        @XmlAttribute(name = "scroll_y")
        protected Double scrollY;
        @XmlAttribute(name = "home_page")
        protected BigInteger homePage;
        @XmlAttribute(name = "home_view")
        protected Boolean homeView;
        @XmlAttribute(name = "page_width")
        protected Double pageWidth;
        @XmlAttribute(name = "page_height")
        protected Double pageHeight;
        @XmlAttribute(name = "show_pages")
        protected Boolean showPages;
        @XmlAttribute(name = "page_orientation")
        protected String pageOrientation;
        @XmlAttribute(name = "page_sequence")
        protected String pageSequence;
        @XmlAttribute(name = "type")
        protected ViewType type;
        @XmlAttribute(name = "x")
        protected Integer x;
        @XmlAttribute(name = "y")
        protected Integer y;
        @XmlAttribute(name = "content")
        protected String content;

        /**
         * Gets the value of the background property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getBackground() {
            return background;
        }

        /**
         * Sets the value of the background property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setBackground(String value) {
            this.background = value;
        }

        /**
         * Gets the value of the zoom property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public Double getZoom() {
            return zoom;
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
         * Gets the value of the scrollX property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public Double getScrollX() {
            return scrollX;
        }

        /**
         * Sets the value of the scrollX property.
         *
         * @param value
         *     allowed object is
         *     {@link Double }
         *
         */
        public void setScrollX(Double value) {
            this.scrollX = value;
        }

        /**
         * Gets the value of the scrollY property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public Double getScrollY() {
            return scrollY;
        }

        /**
         * Sets the value of the scrollY property.
         *
         * @param value
         *     allowed object is
         *     {@link Double }
         *
         */
        public void setScrollY(Double value) {
            this.scrollY = value;
        }

        /**
         * Gets the value of the homePage property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getHomePage() {
            return homePage;
        }

        /**
         * Sets the value of the homePage property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setHomePage(BigInteger value) {
            this.homePage = value;
        }

        /**
         * Gets the value of the homeView property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isHomeView() {
            return homeView;
        }

        /**
         * Sets the value of the homeView property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setHomeView(Boolean value) {
            this.homeView = value;
        }

        /**
         * Gets the value of the pageWidth property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public Double getPageWidth() {
            return pageWidth;
        }

        /**
         * Sets the value of the pageWidth property.
         *
         * @param value
         *     allowed object is
         *     {@link Double }
         *
         */
        public void setPageWidth(Double value) {
            this.pageWidth = value;
        }

        /**
         * Gets the value of the pageHeight property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public Double getPageHeight() {
            return pageHeight;
        }

        /**
         * Sets the value of the pageHeight property.
         *
         * @param value
         *     allowed object is
         *     {@link Double }
         *
         */
        public void setPageHeight(Double value) {
            this.pageHeight = value;
        }

        /**
         * Gets the value of the showPages property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isShowPages() {
            return showPages;
        }

        /**
         * Sets the value of the showPages property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setShowPages(Boolean value) {
            this.showPages = value;
        }

        /**
         * Gets the value of the pageOrientation property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPageOrientation() {
            return pageOrientation;
        }

        /**
         * Sets the value of the pageOrientation property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPageOrientation(String value) {
            this.pageOrientation = value;
        }

        /**
         * Gets the value of the pageSequence property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPageSequence() {
            return pageSequence;
        }

        /**
         * Sets the value of the pageSequence property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPageSequence(String value) {
            this.pageSequence = value;
        }

        /**
         * Gets the value of the type property.
         *
         * @return
         *     possible object is
         *     {@link ViewType }
         *
         */
        public ViewType getType() {
            if (type == null) {
                return ViewType.STOCK_FLOW;
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         *
         * @param value
         *     allowed object is
         *     {@link ViewType }
         *
         */
        public void setType(ViewType value) {
            this.type = value;
        }

        /**
         * Gets the value of the x property.
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getX() {
            return x;
        }

        /**
         * Sets the value of the x property.
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setX(Integer value) {
            this.x = value;
        }

        /**
         * Gets the value of the y property.
         *
         * @return
         *     possible object is
         *     {@link Integer }
         *
         */
        public Integer getY() {
            return y;
        }

        /**
         * Sets the value of the y property.
         *
         * @param value
         *     allowed object is
         *     {@link Integer }
         *
         */
        public void setY(Integer value) {
            this.y = value;
        }

        /**
         * Gets the value of the content property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContent(String value) {
            this.content = value;
        }

    }

}
