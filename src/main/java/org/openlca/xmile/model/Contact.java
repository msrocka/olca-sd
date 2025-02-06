
package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

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
