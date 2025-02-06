
package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eqnOrMathmlOrUnits"
})
@XmlRootElement(name = "stock", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Stock {

    @XmlElementRefs({
        @XmlElementRef(name = "eqn", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "mathml", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "units", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "doc", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gf", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Gf.class, required = false),
        @XmlElementRef(name = "dimensions", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Dimensions.class, required = false),
        @XmlElementRef(name = "event_poster", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = EventPoster.class, required = false),
        @XmlElementRef(name = "scale", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Scale.class, required = false),
        @XmlElementRef(name = "range", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Range.class, required = false),
        @XmlElementRef(name = "format", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Format.class, required = false),
        @XmlElementRef(name = "inflow", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "outflow", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "queue", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "non_negative", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "conveyor", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Conveyor.class, required = false),
        @XmlElementRef(name = "element", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false)
    })
    protected List<Object> eqnOrMathmlOrUnits;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "access")
    protected AccessType access;
    @XmlAttribute(name = "autoexport")
    protected Boolean autoexport;
    @XmlAttribute(name = "subscript")
    protected String subscript;

    /**
     * Gets the value of the eqnOrMathmlOrUnits property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eqnOrMathmlOrUnits property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEqnOrMathmlOrUnits().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Gf }
     * {@link Dimensions }
     * {@link EventPoster }
     * {@link Scale }
     * {@link Range }
     * {@link Format }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     * {@link Conveyor }
     * {@link JAXBElement }{@code <}{@link Element }{@code >}
     *
     *
     */
    public List<Object> getEqnOrMathmlOrUnits() {
        if (eqnOrMathmlOrUnits == null) {
            eqnOrMathmlOrUnits = new ArrayList<Object>();
        }
        return this.eqnOrMathmlOrUnits;
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
     * Gets the value of the access property.
     *
     * @return
     *     possible object is
     *     {@link AccessType }
     *
     */
    public AccessType getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     *
     * @param value
     *     allowed object is
     *     {@link AccessType }
     *
     */
    public void setAccess(AccessType value) {
        this.access = value;
    }

    /**
     * Gets the value of the autoexport property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isAutoexport() {
        if (autoexport == null) {
            return false;
        } else {
            return autoexport;
        }
    }

    /**
     * Sets the value of the autoexport property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAutoexport(Boolean value) {
        this.autoexport = value;
    }

    /**
     * Gets the value of the subscript property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscript() {
        return subscript;
    }

    /**
     * Sets the value of the subscript property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscript(String value) {
        this.subscript = value;
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
     *       &lt;choice maxOccurs="unbounded"&gt;
     *         &lt;element name="eqn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="mathml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}gf" minOccurs="0"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}event_poster" minOccurs="0"/&gt;
     *         &lt;element name="inflow" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="outflow" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="queue" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}empty_type" minOccurs="0"/&gt;
     *         &lt;element name="non_negative" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}boolean_or_empty_type" minOccurs="0"/&gt;
     *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}conveyor" minOccurs="0"/&gt;
     *       &lt;/choice&gt;
     *       &lt;attribute name="subscript" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "eqnOrMathmlOrGf"
    })
    public static class Element {

        @XmlElementRefs({
            @XmlElementRef(name = "eqn", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "mathml", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "gf", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Gf.class, required = false),
            @XmlElementRef(name = "event_poster", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = EventPoster.class, required = false),
            @XmlElementRef(name = "inflow", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "outflow", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "queue", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "non_negative", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "conveyor", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Conveyor.class, required = false)
        })
        protected List<Object> eqnOrMathmlOrGf;
        @XmlAttribute(name = "subscript", required = true)
        protected String subscript;

        /**
         * Gets the value of the eqnOrMathmlOrGf property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the eqnOrMathmlOrGf property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEqnOrMathmlOrGf().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link Gf }
         * {@link EventPoster }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
         * {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
         * {@link Conveyor }
         *
         *
         */
        public List<Object> getEqnOrMathmlOrGf() {
            if (eqnOrMathmlOrGf == null) {
                eqnOrMathmlOrGf = new ArrayList<Object>();
            }
            return this.eqnOrMathmlOrGf;
        }

        /**
         * Gets the value of the subscript property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSubscript() {
            return subscript;
        }

        /**
         * Sets the value of the subscript property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSubscript(String value) {
            this.subscript = value;
        }

    }

}
