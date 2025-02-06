
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
 *         &lt;element name="stock" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="flow"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
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
@XmlRootElement(name = "behavior", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Behavior {

    @XmlElement(name = "non_negative", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected BooleanOrEmptyType nonNegative;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Behavior.Stock stock;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected Behavior.Flow flow;

    /**
     * Gets the value of the nonNegative property.
     *
     * @return
     *     possible object is
     *     {@link BooleanOrEmptyType }
     *
     */
    public BooleanOrEmptyType getNonNegative() {
        return nonNegative;
    }

    /**
     * Sets the value of the nonNegative property.
     *
     * @param value
     *     allowed object is
     *     {@link BooleanOrEmptyType }
     *
     */
    public void setNonNegative(BooleanOrEmptyType value) {
        this.nonNegative = value;
    }

    /**
     * Gets the value of the stock property.
     *
     * @return
     *     possible object is
     *     {@link Stock }
     *
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     *
     * @param value
     *     allowed object is
     *     {@link Stock }
     *
     */
    public void setStock(Stock value) {
        this.stock = value;
    }

    /**
     * Gets the value of the flow property.
     *
     * @return
     *     possible object is
     *     {@link Flow }
     *
     */
    public Flow getFlow() {
        return flow;
    }

    /**
     * Sets the value of the flow property.
     *
     * @param value
     *     allowed object is
     *     {@link Flow }
     *
     */
    public void setFlow(Flow value) {
        this.flow = value;
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
     *       &lt;all&gt;
     *         &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
     *       &lt;/all&gt;
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
    public static class Flow {

        @XmlElement(name = "non_negative", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected BooleanOrEmptyType nonNegative;

        /**
         * Gets the value of the nonNegative property.
         *
         * @return
         *     possible object is
         *     {@link BooleanOrEmptyType }
         *
         */
        public BooleanOrEmptyType getNonNegative() {
            return nonNegative;
        }

        /**
         * Sets the value of the nonNegative property.
         *
         * @param value
         *     allowed object is
         *     {@link BooleanOrEmptyType }
         *
         */
        public void setNonNegative(BooleanOrEmptyType value) {
            this.nonNegative = value;
        }

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
     *       &lt;all&gt;
     *         &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
     *       &lt;/all&gt;
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
    public static class Stock {

        @XmlElement(name = "non_negative", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected BooleanOrEmptyType nonNegative;

        /**
         * Gets the value of the nonNegative property.
         *
         * @return
         *     possible object is
         *     {@link BooleanOrEmptyType }
         *
         */
        public BooleanOrEmptyType getNonNegative() {
            return nonNegative;
        }

        /**
         * Sets the value of the nonNegative property.
         *
         * @param value
         *     allowed object is
         *     {@link BooleanOrEmptyType }
         *
         */
        public void setNonNegative(BooleanOrEmptyType value) {
            this.nonNegative = value;
        }

    }

}
