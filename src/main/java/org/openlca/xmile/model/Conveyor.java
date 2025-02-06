
package org.openlca.xmile.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "conveyor", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Conveyor {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String len;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String capacity;
    @XmlElement(name = "in_limit", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String inLimit;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String sample;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected String arrest;
    @XmlAttribute(name = "discrete")
    protected Boolean discrete;
    @XmlAttribute(name = "batch_integrity")
    protected Boolean batchIntegrity;
    @XmlAttribute(name = "one_at_a_time")
    protected Boolean oneAtATime;
    @XmlAttribute(name = "exponential_leak")
    protected Boolean exponentialLeak;

    /**
     * Gets the value of the len property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLen() {
        return len;
    }

    /**
     * Sets the value of the len property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLen(String value) {
        this.len = value;
    }

    /**
     * Gets the value of the capacity property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCapacity(String value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the inLimit property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInLimit() {
        return inLimit;
    }

    /**
     * Sets the value of the inLimit property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInLimit(String value) {
        this.inLimit = value;
    }

    /**
     * Gets the value of the sample property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSample() {
        return sample;
    }

    /**
     * Sets the value of the sample property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSample(String value) {
        this.sample = value;
    }

    /**
     * Gets the value of the arrest property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getArrest() {
        return arrest;
    }

    /**
     * Sets the value of the arrest property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArrest(String value) {
        this.arrest = value;
    }

    /**
     * Gets the value of the discrete property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isDiscrete() {
        if (discrete == null) {
            return false;
        } else {
            return discrete;
        }
    }

    /**
     * Sets the value of the discrete property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDiscrete(Boolean value) {
        this.discrete = value;
    }

    /**
     * Gets the value of the batchIntegrity property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isBatchIntegrity() {
        if (batchIntegrity == null) {
            return false;
        } else {
            return batchIntegrity;
        }
    }

    /**
     * Sets the value of the batchIntegrity property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setBatchIntegrity(Boolean value) {
        this.batchIntegrity = value;
    }

    /**
     * Gets the value of the oneAtATime property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isOneAtATime() {
        if (oneAtATime == null) {
            return true;
        } else {
            return oneAtATime;
        }
    }

    /**
     * Sets the value of the oneAtATime property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOneAtATime(Boolean value) {
        this.oneAtATime = value;
    }

    /**
     * Gets the value of the exponentialLeak property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isExponentialLeak() {
        if (exponentialLeak == null) {
            return false;
        } else {
            return exponentialLeak;
        }
    }

    /**
     * Sets the value of the exponentialLeak property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setExponentialLeak(Boolean value) {
        this.exponentialLeak = value;
    }

}
