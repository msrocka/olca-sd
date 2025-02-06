
package org.openlca.xmile.model;


import java.math.BigInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "options", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Options {

    @XmlElement(name = "uses_conveyor", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesConveyor usesConveyor;
    @XmlElement(name = "uses_queue", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesQueue usesQueue;
    @XmlElement(name = "uses_submodels", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected EmptyType usesSubmodels;
    @XmlElement(name = "uses_macros", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesMacros usesMacros;
    @XmlElement(name = "uses_event_posters", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesEventPosters usesEventPosters;
    @XmlElement(name = "has_model_view", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected EmptyType hasModelView;
    @XmlElement(name = "uses_outputs", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesOutputs usesOutputs;
    @XmlElement(name = "uses_inputs", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesInputs usesInputs;
    @XmlElement(name = "uses_annotation", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected EmptyType usesAnnotation;
    @XmlElement(name = "uses_arrays", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected Options.UsesArrays usesArrays;
    @XmlAttribute(name = "namespace")
    protected String namespace;

    /**
     * Gets the value of the usesConveyor property.
     *
     * @return
     *     possible object is
     *     {@link UsesConveyor }
     *
     */
    public UsesConveyor getUsesConveyor() {
        return usesConveyor;
    }

    /**
     * Sets the value of the usesConveyor property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesConveyor }
     *
     */
    public void setUsesConveyor(UsesConveyor value) {
        this.usesConveyor = value;
    }

    /**
     * Gets the value of the usesQueue property.
     *
     * @return
     *     possible object is
     *     {@link UsesQueue }
     *
     */
    public UsesQueue getUsesQueue() {
        return usesQueue;
    }

    /**
     * Sets the value of the usesQueue property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesQueue }
     *
     */
    public void setUsesQueue(UsesQueue value) {
        this.usesQueue = value;
    }

    /**
     * Gets the value of the usesSubmodels property.
     *
     * @return
     *     possible object is
     *     {@link EmptyType }
     *
     */
    public EmptyType getUsesSubmodels() {
        return usesSubmodels;
    }

    /**
     * Sets the value of the usesSubmodels property.
     *
     * @param value
     *     allowed object is
     *     {@link EmptyType }
     *
     */
    public void setUsesSubmodels(EmptyType value) {
        this.usesSubmodels = value;
    }

    /**
     * Gets the value of the usesMacros property.
     *
     * @return
     *     possible object is
     *     {@link UsesMacros }
     *
     */
    public UsesMacros getUsesMacros() {
        return usesMacros;
    }

    /**
     * Sets the value of the usesMacros property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesMacros }
     *
     */
    public void setUsesMacros(UsesMacros value) {
        this.usesMacros = value;
    }

    /**
     * Gets the value of the usesEventPosters property.
     *
     * @return
     *     possible object is
     *     {@link UsesEventPosters }
     *
     */
    public UsesEventPosters getUsesEventPosters() {
        return usesEventPosters;
    }

    /**
     * Sets the value of the usesEventPosters property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesEventPosters }
     *
     */
    public void setUsesEventPosters(UsesEventPosters value) {
        this.usesEventPosters = value;
    }

    /**
     * Gets the value of the hasModelView property.
     *
     * @return
     *     possible object is
     *     {@link EmptyType }
     *
     */
    public EmptyType getHasModelView() {
        return hasModelView;
    }

    /**
     * Sets the value of the hasModelView property.
     *
     * @param value
     *     allowed object is
     *     {@link EmptyType }
     *
     */
    public void setHasModelView(EmptyType value) {
        this.hasModelView = value;
    }

    /**
     * Gets the value of the usesOutputs property.
     *
     * @return
     *     possible object is
     *     {@link UsesOutputs }
     *
     */
    public UsesOutputs getUsesOutputs() {
        return usesOutputs;
    }

    /**
     * Sets the value of the usesOutputs property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesOutputs }
     *
     */
    public void setUsesOutputs(UsesOutputs value) {
        this.usesOutputs = value;
    }

    /**
     * Gets the value of the usesInputs property.
     *
     * @return
     *     possible object is
     *     {@link UsesInputs }
     *
     */
    public UsesInputs getUsesInputs() {
        return usesInputs;
    }

    /**
     * Sets the value of the usesInputs property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesInputs }
     *
     */
    public void setUsesInputs(UsesInputs value) {
        this.usesInputs = value;
    }

    /**
     * Gets the value of the usesAnnotation property.
     *
     * @return
     *     possible object is
     *     {@link EmptyType }
     *
     */
    public EmptyType getUsesAnnotation() {
        return usesAnnotation;
    }

    /**
     * Sets the value of the usesAnnotation property.
     *
     * @param value
     *     allowed object is
     *     {@link EmptyType }
     *
     */
    public void setUsesAnnotation(EmptyType value) {
        this.usesAnnotation = value;
    }

    /**
     * Gets the value of the usesArrays property.
     *
     * @return
     *     possible object is
     *     {@link UsesArrays }
     *
     */
    public UsesArrays getUsesArrays() {
        return usesArrays;
    }

    /**
     * Sets the value of the usesArrays property.
     *
     * @param value
     *     allowed object is
     *     {@link UsesArrays }
     *
     */
    public void setUsesArrays(UsesArrays value) {
        this.usesArrays = value;
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
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="max_dimensions" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *       &lt;attribute name="invalid_index_value" default="0"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double"&gt;
     *             &lt;enumeration value="0"/&gt;
     *             &lt;enumeration value="NaN"/&gt;
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
    public static class UsesArrays {

        @XmlAttribute(name = "max_dimensions", required = true)
        protected BigInteger maxDimensions;
        @XmlAttribute(name = "invalid_index_value")
        protected Double invalidIndexValue;

        /**
         * Gets the value of the maxDimensions property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getMaxDimensions() {
            return maxDimensions;
        }

        /**
         * Sets the value of the maxDimensions property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setMaxDimensions(BigInteger value) {
            this.maxDimensions = value;
        }

        /**
         * Gets the value of the invalidIndexValue property.
         *
         * @return
         *     possible object is
         *     {@link Double }
         *
         */
        public double getInvalidIndexValue() {
            if (invalidIndexValue == null) {
                return  0.0D;
            } else {
                return invalidIndexValue;
            }
        }

        /**
         * Sets the value of the invalidIndexValue property.
         *
         * @param value
         *     allowed object is
         *     {@link Double }
         *
         */
        public void setInvalidIndexValue(Double value) {
            this.invalidIndexValue = value;
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
     *       &lt;attribute name="arrest" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="leak" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesConveyor {

        @XmlAttribute(name = "arrest")
        protected Boolean arrest;
        @XmlAttribute(name = "leak")
        protected Boolean leak;

        /**
         * Gets the value of the arrest property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isArrest() {
            return arrest;
        }

        /**
         * Sets the value of the arrest property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setArrest(Boolean value) {
            this.arrest = value;
        }

        /**
         * Gets the value of the leak property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isLeak() {
            return leak;
        }

        /**
         * Sets the value of the leak property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setLeak(Boolean value) {
            this.leak = value;
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
     *       &lt;attribute name="messages" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesEventPosters {

        @XmlAttribute(name = "messages")
        protected Boolean messages;

        /**
         * Gets the value of the messages property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isMessages() {
            return messages;
        }

        /**
         * Sets the value of the messages property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setMessages(Boolean value) {
            this.messages = value;
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
     *       &lt;attribute name="numeric_input" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="list" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="graphical_input" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesInputs {

        @XmlAttribute(name = "numeric_input")
        protected Boolean numericInput;
        @XmlAttribute(name = "list")
        protected Boolean list;
        @XmlAttribute(name = "graphical_input")
        protected Boolean graphicalInput;

        /**
         * Gets the value of the numericInput property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isNumericInput() {
            return numericInput;
        }

        /**
         * Sets the value of the numericInput property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setNumericInput(Boolean value) {
            this.numericInput = value;
        }

        /**
         * Gets the value of the list property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isList() {
            return list;
        }

        /**
         * Sets the value of the list property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setList(Boolean value) {
            this.list = value;
        }

        /**
         * Gets the value of the graphicalInput property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isGraphicalInput() {
            return graphicalInput;
        }

        /**
         * Sets the value of the graphicalInput property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setGraphicalInput(Boolean value) {
            this.graphicalInput = value;
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
     *       &lt;attribute name="references_macros" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="option_filters" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesMacros {

        @XmlAttribute(name = "references_macros", required = true)
        protected boolean referencesMacros;
        @XmlAttribute(name = "option_filters", required = true)
        protected boolean optionFilters;

        /**
         * Gets the value of the referencesMacros property.
         *
         */
        public boolean isReferencesMacros() {
            return referencesMacros;
        }

        /**
         * Sets the value of the referencesMacros property.
         *
         */
        public void setReferencesMacros(boolean value) {
            this.referencesMacros = value;
        }

        /**
         * Gets the value of the optionFilters property.
         *
         */
        public boolean isOptionFilters() {
            return optionFilters;
        }

        /**
         * Sets the value of the optionFilters property.
         *
         */
        public void setOptionFilters(boolean value) {
            this.optionFilters = value;
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
     *       &lt;attribute name="numeric_display" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="lamp" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="gauge" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesOutputs {

        @XmlAttribute(name = "numeric_display")
        protected Boolean numericDisplay;
        @XmlAttribute(name = "lamp")
        protected Boolean lamp;
        @XmlAttribute(name = "gauge")
        protected Boolean gauge;

        /**
         * Gets the value of the numericDisplay property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isNumericDisplay() {
            return numericDisplay;
        }

        /**
         * Sets the value of the numericDisplay property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setNumericDisplay(Boolean value) {
            this.numericDisplay = value;
        }

        /**
         * Gets the value of the lamp property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isLamp() {
            return lamp;
        }

        /**
         * Sets the value of the lamp property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setLamp(Boolean value) {
            this.lamp = value;
        }

        /**
         * Gets the value of the gauge property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isGauge() {
            return gauge;
        }

        /**
         * Sets the value of the gauge property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setGauge(Boolean value) {
            this.gauge = value;
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
     *       &lt;attribute name="overflow" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsesQueue {

        @XmlAttribute(name = "overflow")
        protected Boolean overflow;

        /**
         * Gets the value of the overflow property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public Boolean isOverflow() {
            return overflow;
        }

        /**
         * Sets the value of the overflow property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setOverflow(Boolean value) {
            this.overflow = value;
        }

    }

}
