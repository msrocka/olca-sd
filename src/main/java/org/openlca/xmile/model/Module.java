
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="connect" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="from" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="resource" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "connect"
})
@XmlRootElement(name = "module", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Module {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected List<Connect> connect;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "resource")
    protected String resource;

    /**
     * Gets the value of the connect property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connect property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnect().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Connect }
     *
     *
     */
    public List<Connect> getConnect() {
        if (connect == null) {
            connect = new ArrayList<Connect>();
        }
        return this.connect;
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
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="from" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Connect {

        @XmlAttribute(name = "to", required = true)
        protected String to;
        @XmlAttribute(name = "from", required = true)
        protected String from;

        /**
         * Gets the value of the to property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTo(String value) {
            this.to = value;
        }

        /**
         * Gets the value of the from property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFrom(String value) {
            this.from = value;
        }

    }

}
