
package org.openlca.xmile.model;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attGroup ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}format_attributes"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "format", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Format {

    @XmlAttribute(name = "precision")
    protected Double precision;
    @XmlAttribute(name = "scale_by")
    protected BigInteger scaleBy;
    @XmlAttribute(name = "delimit_000s")
    protected Boolean delimit000S;
    @XmlAttribute(name = "display_as")
    protected String displayAs;

    /**
     * Gets the value of the precision property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setPrecision(Double value) {
        this.precision = value;
    }

    /**
     * Gets the value of the scaleBy property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getScaleBy() {
        if (scaleBy == null) {
            return new BigInteger("1");
        } else {
            return scaleBy;
        }
    }

    /**
     * Sets the value of the scaleBy property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setScaleBy(BigInteger value) {
        this.scaleBy = value;
    }

    /**
     * Gets the value of the delimit000S property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isDelimit000S() {
        if (delimit000S == null) {
            return false;
        } else {
            return delimit000S;
        }
    }

    /**
     * Sets the value of the delimit000S property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDelimit000S(Boolean value) {
        this.delimit000S = value;
    }

    /**
     * Gets the value of the displayAs property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDisplayAs() {
        if (displayAs == null) {
            return "number";
        } else {
            return displayAs;
        }
    }

    /**
     * Sets the value of the displayAs property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDisplayAs(String value) {
        this.displayAs = value;
    }

}
