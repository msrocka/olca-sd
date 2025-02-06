
package org.openlca.xmile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="stop" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="dt" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;double"&gt;
 *                 &lt;attribute name="reciprocal" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="run" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="by" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="all"/&gt;
 *                       &lt;enumeration value="group"/&gt;
 *                       &lt;enumeration value="module"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="time_units" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}time_unit_type" default="" /&gt;
 *       &lt;attribute name="method" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}method_type" default="euler" /&gt;
 *       &lt;attribute name="pause" type="{http://www.w3.org/2001/XMLSchema}double" default="INF" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "sim_specs", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class SimSpecs {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected double stop;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected double start;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", defaultValue = "1")
    protected SimSpecs.Dt dt;
    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected SimSpecs.Run run;
    @XmlAttribute(name = "time_units")
    protected String timeUnits;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "pause")
    protected Double pause;

    /**
     * Gets the value of the stop property.
     *
     */
    public double getStop() {
        return stop;
    }

    /**
     * Sets the value of the stop property.
     *
     */
    public void setStop(double value) {
        this.stop = value;
    }

    /**
     * Gets the value of the start property.
     *
     */
    public double getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     */
    public void setStart(double value) {
        this.start = value;
    }

    /**
     * Gets the value of the dt property.
     *
     * @return
     *     possible object is
     *     {@link Dt }
     *
     */
    public Dt getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     *
     * @param value
     *     allowed object is
     *     {@link Dt }
     *
     */
    public void setDt(Dt value) {
        this.dt = value;
    }

    /**
     * Gets the value of the run property.
     *
     * @return
     *     possible object is
     *     {@link Run }
     *
     */
    public Run getRun() {
        return run;
    }

    /**
     * Sets the value of the run property.
     *
     * @param value
     *     allowed object is
     *     {@link Run }
     *
     */
    public void setRun(Run value) {
        this.run = value;
    }

    /**
     * Gets the value of the timeUnits property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTimeUnits() {
        if (timeUnits == null) {
            return "";
        } else {
            return timeUnits;
        }
    }

    /**
     * Sets the value of the timeUnits property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTimeUnits(String value) {
        this.timeUnits = value;
    }

    /**
     * Gets the value of the method property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMethod() {
        if (method == null) {
            return "euler";
        } else {
            return method;
        }
    }

    /**
     * Sets the value of the method property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the pause property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public double getPause() {
        if (pause == null) {
            return Double.POSITIVE_INFINITY;
        } else {
            return pause;
        }
    }

    /**
     * Sets the value of the pause property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setPause(Double value) {
        this.pause = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;double"&gt;
     *       &lt;attribute name="reciprocal" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Dt {

        @XmlValue
        protected double value;
        @XmlAttribute(name = "reciprocal")
        protected Boolean reciprocal;

        /**
         * Gets the value of the value property.
         *
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         */
        public void setValue(double value) {
            this.value = value;
        }

        /**
         * Gets the value of the reciprocal property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public boolean isReciprocal() {
            if (reciprocal == null) {
                return false;
            } else {
                return reciprocal;
            }
        }

        /**
         * Sets the value of the reciprocal property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setReciprocal(Boolean value) {
            this.reciprocal = value;
        }

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
     *       &lt;attribute name="by" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="all"/&gt;
     *             &lt;enumeration value="group"/&gt;
     *             &lt;enumeration value="module"/&gt;
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
    @XmlType(name = "")
    public static class Run {

        @XmlAttribute(name = "by", required = true)
        protected String by;

        /**
         * Gets the value of the by property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getBy() {
            return by;
        }

        /**
         * Sets the value of the by property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setBy(String value) {
            this.by = value;
        }

    }

}
