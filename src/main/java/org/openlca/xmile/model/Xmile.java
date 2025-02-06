
package org.openlca.xmile.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "simSpecsOrModelUnitsOrBehavior"
})
@XmlRootElement(name = "xmile", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Xmile {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected Header header;
    @XmlElements({
        @XmlElement(name = "sim_specs", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = SimSpecs.class),
        @XmlElement(name = "model_units", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = ModelUnits.class),
        @XmlElement(name = "behavior", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Behavior.class),
        @XmlElement(name = "data", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Data.class),
        @XmlElement(name = "style", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Style.class),
        @XmlElement(name = "macro", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Macro.class),
        @XmlElement(name = "model", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Model.class),
        @XmlElement(name = "dimensions", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Dimensions.class)
    })
    protected List<Object> simSpecsOrModelUnitsOrBehavior;
    @XmlAttribute(name = "version", required = true)
    protected BigDecimal version;

    /**
     * Gets the value of the header property.
     *
     * @return
     *     possible object is
     *     {@link Header }
     *
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value
     *     allowed object is
     *     {@link Header }
     *
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the simSpecsOrModelUnitsOrBehavior property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simSpecsOrModelUnitsOrBehavior property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimSpecsOrModelUnitsOrBehavior().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimSpecs }
     * {@link ModelUnits }
     * {@link Behavior }
     * {@link Data }
     * {@link Style }
     * {@link Macro }
     * {@link Model }
     * {@link Dimensions }
     *
     *
     */
    public List<Object> getSimSpecsOrModelUnitsOrBehavior() {
        if (simSpecsOrModelUnitsOrBehavior == null) {
            simSpecsOrModelUnitsOrBehavior = new ArrayList<Object>();
        }
        return this.simSpecsOrModelUnitsOrBehavior;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="dim" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence maxOccurs="unbounded"&gt;
     *                   &lt;element name="elem" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dim"
    })
    public static class Dimensions {

        @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected List<Dim> dim;

        /**
         * Gets the value of the dim property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dim property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDim().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Dim }
         *
         *
         */
        public List<Dim> getDim() {
            if (dim == null) {
                dim = new ArrayList<Dim>();
            }
            return this.dim;
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
         *       &lt;sequence maxOccurs="unbounded"&gt;
         *         &lt;element name="elem" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "elem"
        })
        public static class Dim {

            @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
            protected List<Elem> elem;
            @XmlAttribute(name = "name", required = true)
            protected String name;
            @XmlAttribute(name = "size")
            protected Integer size;

            /**
             * Gets the value of the elem property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the elem property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getElem().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Elem }
             *
             *
             */
            public List<Elem> getElem() {
                if (elem == null) {
                    elem = new ArrayList<Elem>();
                }
                return this.elem;
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
             * Gets the value of the size property.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getSize() {
                return size;
            }

            /**
             * Sets the value of the size property.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setSize(Integer value) {
                this.size = value;
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
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Elem {

                @XmlAttribute(name = "name", required = true)
                protected String name;

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

            }

        }

    }

}
