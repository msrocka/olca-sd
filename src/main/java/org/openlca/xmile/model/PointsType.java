
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for points_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="points_type"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="sep" type="{http://www.w3.org/2001/XMLSchema}string" default="," /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "points_type", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", propOrder = {
    "value"
})
public class PointsType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "sep")
    protected String sep;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the sep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSep() {
        if (sep == null) {
            return ",";
        } else {
            return sep;
        }
    }

    /**
     * Sets the value of the sep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSep(String value) {
        this.sep = value;
    }

}
