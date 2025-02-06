
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "include"
})
@XmlRootElement(name = "includes", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Includes {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected List<Include> include;

    /**
     * Gets the value of the include property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the include property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInclude().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Include }
     *
     *
     */
    public List<Include> getInclude() {
        if (include == null) {
            include = new ArrayList<Include>();
        }
        return this.include;
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
     *       &lt;attribute name="resource" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Include {

        @XmlAttribute(name = "resource", required = true)
        protected String resource;

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

    }

}
