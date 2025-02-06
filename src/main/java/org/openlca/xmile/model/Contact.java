
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="website" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "addressOrPhoneOrFax"
})
@XmlRootElement(name = "contact", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Contact {

    @XmlElementRefs({
        @XmlElementRef(name = "address", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "phone", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "fax", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "email", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "website", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> addressOrPhoneOrFax;

    /**
     * Gets the value of the addressOrPhoneOrFax property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressOrPhoneOrFax property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressOrPhoneOrFax().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     *
     */
    public List<JAXBElement<String>> getAddressOrPhoneOrFax() {
        if (addressOrPhoneOrFax == null) {
            addressOrPhoneOrFax = new ArrayList<JAXBElement<String>>();
        }
        return this.addressOrPhoneOrFax;
    }

}
