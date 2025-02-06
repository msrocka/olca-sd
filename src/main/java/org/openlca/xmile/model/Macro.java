
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="parm" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="eqn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}sim_specs" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}variables" minOccurs="0"/&gt;
 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}views" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="namespace" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="filter"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="stock"/&gt;
 *             &lt;enumeration value="flow"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="applyto"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="inflows"/&gt;
 *             &lt;enumeration value="outflows"/&gt;
 *             &lt;enumeration value="upstream"/&gt;
 *             &lt;enumeration value="downstream"/&gt;
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
    "parmOrEqnOrFormat"
})
@XmlRootElement(name = "macro", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Macro {

    @XmlElementRefs({
        @XmlElementRef(name = "parm", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "eqn", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "format", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "doc", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sim_specs", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = SimSpecs.class, required = false),
        @XmlElementRef(name = "variables", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Variables.class, required = false),
        @XmlElementRef(name = "views", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Views.class, required = false)
    })
    protected List<Object> parmOrEqnOrFormat;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "namespace")
    protected String namespace;
    @XmlAttribute(name = "filter")
    protected String filter;
    @XmlAttribute(name = "applyto")
    protected String applyto;

    /**
     * Gets the value of the parmOrEqnOrFormat property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parmOrEqnOrFormat property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParmOrEqnOrFormat().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link SimSpecs }
     * {@link Variables }
     * {@link Views }
     *
     *
     */
    public List<Object> getParmOrEqnOrFormat() {
        if (parmOrEqnOrFormat == null) {
            parmOrEqnOrFormat = new ArrayList<Object>();
        }
        return this.parmOrEqnOrFormat;
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
     * Gets the value of the namespace property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the filter property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFilter(String value) {
        this.filter = value;
    }

    /**
     * Gets the value of the applyto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplyto() {
        return applyto;
    }

    /**
     * Sets the value of the applyto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplyto(String value) {
        this.applyto = value;
    }

}
