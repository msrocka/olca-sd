
package org.openlca.xmile.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence maxOccurs="unbounded"&gt;
 *         &lt;element name="threshold"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="event" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice maxOccurs="unbounded"&gt;
 *                             &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}text_box"/&gt;
 *                             &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}image"/&gt;
 *                             &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}video"/&gt;
 *                             &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}sound"/&gt;
 *                             &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}link"/&gt;
 *                           &lt;/choice&gt;
 *                           &lt;attribute name="sim_action" default="pause"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="pause"/&gt;
 *                                 &lt;enumeration value="stop"/&gt;
 *                                 &lt;enumeration value="message"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *                 &lt;attribute name="direction" default="increasing"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="increasing"/&gt;
 *                       &lt;enumeration value="decreasing"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="repeat" default="each"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="each"/&gt;
 *                       &lt;enumeration value="once"/&gt;
 *                       &lt;enumeration value="once_ever"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="min" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="max" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "threshold"
})
@XmlRootElement(name = "event_poster", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class EventPoster {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", required = true)
    protected List<Threshold> threshold;
    @XmlAttribute(name = "min", required = true)
    protected double min;
    @XmlAttribute(name = "max", required = true)
    protected double max;

    /**
     * Gets the value of the threshold property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the threshold property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThreshold().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Threshold }
     *
     *
     */
    public List<Threshold> getThreshold() {
        if (threshold == null) {
            threshold = new ArrayList<Threshold>();
        }
        return this.threshold;
    }

    /**
     * Gets the value of the min property.
     *
     */
    public double getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     *
     */
    public void setMin(double value) {
        this.min = value;
    }

    /**
     * Gets the value of the max property.
     *
     */
    public double getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     *
     */
    public void setMax(double value) {
        this.max = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="event" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice maxOccurs="unbounded"&gt;
     *                   &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}text_box"/&gt;
     *                   &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}image"/&gt;
     *                   &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}video"/&gt;
     *                   &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}sound"/&gt;
     *                   &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}link"/&gt;
     *                 &lt;/choice&gt;
     *                 &lt;attribute name="sim_action" default="pause"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;enumeration value="pause"/&gt;
     *                       &lt;enumeration value="stop"/&gt;
     *                       &lt;enumeration value="message"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
     *       &lt;attribute name="direction" default="increasing"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="increasing"/&gt;
     *             &lt;enumeration value="decreasing"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="repeat" default="each"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="each"/&gt;
     *             &lt;enumeration value="once"/&gt;
     *             &lt;enumeration value="once_ever"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "event"
    })
    public static class Threshold {

        @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected List<Event> event;
        @XmlAttribute(name = "value", required = true)
        protected double value;
        @XmlAttribute(name = "direction")
        protected String direction;
        @XmlAttribute(name = "repeat")
        protected String repeat;
        @XmlAttribute(name = "interval")
        protected BigInteger interval;

        /**
         * Gets the value of the event property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the event property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvent().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Event }
         *
         *
         */
        public List<Event> getEvent() {
            if (event == null) {
                event = new ArrayList<Event>();
            }
            return this.event;
        }

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
         * Gets the value of the direction property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDirection() {
            if (direction == null) {
                return "increasing";
            } else {
                return direction;
            }
        }

        /**
         * Sets the value of the direction property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDirection(String value) {
            this.direction = value;
        }

        /**
         * Gets the value of the repeat property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRepeat() {
            if (repeat == null) {
                return "each";
            } else {
                return repeat;
            }
        }

        /**
         * Sets the value of the repeat property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRepeat(String value) {
            this.repeat = value;
        }

        /**
         * Gets the value of the interval property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getInterval() {
            return interval;
        }

        /**
         * Sets the value of the interval property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setInterval(BigInteger value) {
            this.interval = value;
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
         *       &lt;choice maxOccurs="unbounded"&gt;
         *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}text_box"/&gt;
         *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}image"/&gt;
         *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}video"/&gt;
         *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}sound"/&gt;
         *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}link"/&gt;
         *       &lt;/choice&gt;
         *       &lt;attribute name="sim_action" default="pause"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="pause"/&gt;
         *             &lt;enumeration value="stop"/&gt;
         *             &lt;enumeration value="message"/&gt;
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
            "textBoxOrImageOrVideo"
        })
        public static class Event {

            @XmlElements({
                @XmlElement(name = "text_box", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = TextBox.class),
                @XmlElement(name = "image", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Image.class),
                @XmlElement(name = "video", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Video.class),
                @XmlElement(name = "sound", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Sound.class),
                @XmlElement(name = "link", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", type = Link.class)
            })
            protected List<Object> textBoxOrImageOrVideo;
            @XmlAttribute(name = "sim_action")
            protected String simAction;

            /**
             * Gets the value of the textBoxOrImageOrVideo property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the textBoxOrImageOrVideo property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTextBoxOrImageOrVideo().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TextBox }
             * {@link Image }
             * {@link Video }
             * {@link Sound }
             * {@link Link }
             *
             *
             */
            public List<Object> getTextBoxOrImageOrVideo() {
                if (textBoxOrImageOrVideo == null) {
                    textBoxOrImageOrVideo = new ArrayList<Object>();
                }
                return this.textBoxOrImageOrVideo;
            }

            /**
             * Gets the value of the simAction property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSimAction() {
                if (simAction == null) {
                    return "pause";
                } else {
                    return simAction;
                }
            }

            /**
             * Sets the value of the simAction property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSimAction(String value) {
                this.simAction = value;
            }

        }

    }

}
