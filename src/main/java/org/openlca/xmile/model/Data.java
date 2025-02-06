
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;choice&gt;
 *         &lt;element name="export" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="all" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *                   &lt;element name="table" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="use_settings" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *                 &lt;attGroup ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}data_attributes"/&gt;
 *                 &lt;attribute name="interval" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}report_interval" default="0" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="import" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attGroup ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}data_attributes"/&gt;
 *                 &lt;attribute name="interval" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}report_interval" default="0" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "export",
    "_import"
})
@XmlRootElement(name = "data", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
public class Data {

    @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected List<Export> export;
    @XmlElement(name = "import", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
    protected List<Import> _import;

    /**
     * Gets the value of the export property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the export property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExport().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Export }
     *
     *
     */
    public List<Export> getExport() {
        if (export == null) {
            export = new ArrayList<Export>();
        }
        return this.export;
    }

    /**
     * Gets the value of the import property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the import property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImport().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Import }
     *
     *
     */
    public List<Import> getImport() {
        if (_import == null) {
            _import = new ArrayList<Import>();
        }
        return this._import;
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
     *       &lt;choice&gt;
     *         &lt;element name="all" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
     *         &lt;element name="table" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="use_settings" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *       &lt;attGroup ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}data_attributes"/&gt;
     *       &lt;attribute name="interval" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}report_interval" default="0" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "all",
        "table"
    })
    public static class Export {

        @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected Object all;
        @XmlElement(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
        protected Data.Export.Table table;
        @XmlAttribute(name = "interval")
        protected String interval;
        @XmlAttribute(name = "type")
        protected DataType type;
        @XmlAttribute(name = "enable")
        protected Boolean enable;
        @XmlAttribute(name = "frequency")
        protected FrequencyType frequency;
        @XmlAttribute(name = "orientation")
        protected OrientationType orientation;
        @XmlAttribute(name = "resource", required = true)
        protected String resource;
        @XmlAttribute(name = "worksheet")
        protected String worksheet;

        /**
         * Gets the value of the all property.
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getAll() {
            return all;
        }

        /**
         * Sets the value of the all property.
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setAll(Object value) {
            this.all = value;
        }

        /**
         * Gets the value of the table property.
         *
         * @return
         *     possible object is
         *     {@link Table }
         *
         */
        public Table getTable() {
            return table;
        }

        /**
         * Sets the value of the table property.
         *
         * @param value
         *     allowed object is
         *     {@link Table }
         *
         */
        public void setTable(Table value) {
            this.table = value;
        }

        /**
         * Gets the value of the interval property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getInterval() {
            if (interval == null) {
                return "0";
            } else {
                return interval;
            }
        }

        /**
         * Sets the value of the interval property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setInterval(String value) {
            this.interval = value;
        }

        /**
         * Gets the value of the type property.
         *
         * @return
         *     possible object is
         *     {@link DataType }
         *
         */
        public DataType getType() {
            if (type == null) {
                return DataType.CSV;
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         *
         * @param value
         *     allowed object is
         *     {@link DataType }
         *
         */
        public void setType(DataType value) {
            this.type = value;
        }

        /**
         * Gets the value of the enable property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public boolean isEnable() {
            if (enable == null) {
                return true;
            } else {
                return enable;
            }
        }

        /**
         * Sets the value of the enable property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setEnable(Boolean value) {
            this.enable = value;
        }

        /**
         * Gets the value of the frequency property.
         *
         * @return
         *     possible object is
         *     {@link FrequencyType }
         *
         */
        public FrequencyType getFrequency() {
            if (frequency == null) {
                return FrequencyType.AUTOMATIC;
            } else {
                return frequency;
            }
        }

        /**
         * Sets the value of the frequency property.
         *
         * @param value
         *     allowed object is
         *     {@link FrequencyType }
         *
         */
        public void setFrequency(FrequencyType value) {
            this.frequency = value;
        }

        /**
         * Gets the value of the orientation property.
         *
         * @return
         *     possible object is
         *     {@link OrientationType }
         *
         */
        public OrientationType getOrientation() {
            if (orientation == null) {
                return OrientationType.VERTICAL;
            } else {
                return orientation;
            }
        }

        /**
         * Sets the value of the orientation property.
         *
         * @param value
         *     allowed object is
         *     {@link OrientationType }
         *
         */
        public void setOrientation(OrientationType value) {
            this.orientation = value;
        }

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

        /**
         * Gets the value of the worksheet property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWorksheet() {
            return worksheet;
        }

        /**
         * Sets the value of the worksheet property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWorksheet(String value) {
            this.worksheet = value;
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
         *       &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="use_settings" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Table {

            @XmlAttribute(name = "uid", required = true)
            protected String uid;
            @XmlAttribute(name = "use_settings")
            protected Boolean useSettings;

            /**
             * Gets the value of the uid property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getUid() {
                return uid;
            }

            /**
             * Sets the value of the uid property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setUid(String value) {
                this.uid = value;
            }

            /**
             * Gets the value of the useSettings property.
             *
             * @return
             *     possible object is
             *     {@link Boolean }
             *
             */
            public boolean isUseSettings() {
                if (useSettings == null) {
                    return false;
                } else {
                    return useSettings;
                }
            }

            /**
             * Sets the value of the useSettings property.
             *
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *
             */
            public void setUseSettings(Boolean value) {
                this.useSettings = value;
            }

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
     *       &lt;attGroup ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}data_attributes"/&gt;
     *       &lt;attribute name="interval" type="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}report_interval" default="0" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Import {

        @XmlAttribute(name = "interval")
        protected String interval;
        @XmlAttribute(name = "type")
        protected DataType type;
        @XmlAttribute(name = "enable")
        protected Boolean enable;
        @XmlAttribute(name = "frequency")
        protected FrequencyType frequency;
        @XmlAttribute(name = "orientation")
        protected OrientationType orientation;
        @XmlAttribute(name = "resource", required = true)
        protected String resource;
        @XmlAttribute(name = "worksheet")
        protected String worksheet;

        /**
         * Gets the value of the interval property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getInterval() {
            if (interval == null) {
                return "0";
            } else {
                return interval;
            }
        }

        /**
         * Sets the value of the interval property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setInterval(String value) {
            this.interval = value;
        }

        /**
         * Gets the value of the type property.
         *
         * @return
         *     possible object is
         *     {@link DataType }
         *
         */
        public DataType getType() {
            if (type == null) {
                return DataType.CSV;
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         *
         * @param value
         *     allowed object is
         *     {@link DataType }
         *
         */
        public void setType(DataType value) {
            this.type = value;
        }

        /**
         * Gets the value of the enable property.
         *
         * @return
         *     possible object is
         *     {@link Boolean }
         *
         */
        public boolean isEnable() {
            if (enable == null) {
                return true;
            } else {
                return enable;
            }
        }

        /**
         * Sets the value of the enable property.
         *
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *
         */
        public void setEnable(Boolean value) {
            this.enable = value;
        }

        /**
         * Gets the value of the frequency property.
         *
         * @return
         *     possible object is
         *     {@link FrequencyType }
         *
         */
        public FrequencyType getFrequency() {
            if (frequency == null) {
                return FrequencyType.AUTOMATIC;
            } else {
                return frequency;
            }
        }

        /**
         * Sets the value of the frequency property.
         *
         * @param value
         *     allowed object is
         *     {@link FrequencyType }
         *
         */
        public void setFrequency(FrequencyType value) {
            this.frequency = value;
        }

        /**
         * Gets the value of the orientation property.
         *
         * @return
         *     possible object is
         *     {@link OrientationType }
         *
         */
        public OrientationType getOrientation() {
            if (orientation == null) {
                return OrientationType.VERTICAL;
            } else {
                return orientation;
            }
        }

        /**
         * Sets the value of the orientation property.
         *
         * @param value
         *     allowed object is
         *     {@link OrientationType }
         *
         */
        public void setOrientation(OrientationType value) {
            this.orientation = value;
        }

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

        /**
         * Gets the value of the worksheet property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getWorksheet() {
            return worksheet;
        }

        /**
         * Sets the value of the worksheet property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setWorksheet(String value) {
            this.worksheet = value;
        }

    }

}
