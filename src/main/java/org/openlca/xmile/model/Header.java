
package org.openlca.xmile.model;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "header", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Header {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String vendor;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String name;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String version;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String caption;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String author;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String affiliation;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String client;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String copyright;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar created;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar modified;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String uuid;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Image image;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options options;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Product product;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Contact contact;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Includes includes;

    /**
     * Gets the value of the vendor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVendor(String value) {
        this.vendor = value;
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
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the caption property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the value of the caption property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCaption(String value) {
        this.caption = value;
    }

    /**
     * Gets the value of the author property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the affiliation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the value of the affiliation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAffiliation(String value) {
        this.affiliation = value;
    }

    /**
     * Gets the value of the client property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Gets the value of the copyright property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets the value of the copyright property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCopyright(String value) {
        this.copyright = value;
    }

    /**
     * Gets the value of the created property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the modified property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setModified(XMLGregorianCalendar value) {
        this.modified = value;
    }

    /**
     * Gets the value of the uuid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the image property.
     *
     * @return
     *     possible object is
     *     {@link Image }
     *
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     *
     * @param value
     *     allowed object is
     *     {@link Image }
     *
     */
    public void setImage(Image value) {
        this.image = value;
    }

    /**
     * Gets the value of the options property.
     *
     * @return
     *     possible object is
     *     {@link Options }
     *
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     *
     * @param value
     *     allowed object is
     *     {@link Options }
     *
     */
    public void setOptions(Options value) {
        this.options = value;
    }

    /**
     * Gets the value of the product property.
     *
     * @return
     *     possible object is
     *     {@link Product }
     *
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     *
     * @param value
     *     allowed object is
     *     {@link Product }
     *
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the contact property.
     *
     * @return
     *     possible object is
     *     {@link Contact }
     *
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     *
     * @param value
     *     allowed object is
     *     {@link Contact }
     *
     */
    public void setContact(Contact value) {
        this.contact = value;
    }

    /**
     * Gets the value of the includes property.
     *
     * @return
     *     possible object is
     *     {@link Includes }
     *
     */
    public Includes getIncludes() {
        return includes;
    }

    /**
     * Sets the value of the includes property.
     *
     * @param value
     *     allowed object is
     *     {@link Includes }
     *
     */
    public void setIncludes(Includes value) {
        this.includes = value;
    }

}
