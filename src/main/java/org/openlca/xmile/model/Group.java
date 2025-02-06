
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"docOrEntity"
})
@XmlRootElement(name = "group", namespace = Xmile.NS)
public final class Group implements Variable {

	@XmlElements({
		@XmlElement(name = "doc", namespace = Xmile.NS, type = String.class),
		@XmlElement(name = "entity", namespace = Xmile.NS, type = Entity.class)
	})
	private List<Object> docOrEntity;
	@XmlAttribute(name = "name", required = true)
	private String name;

	/**
	 * Gets the value of the docOrEntity property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the docOrEntity property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getDocOrEntity().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link String }
	 * {@link Entity }
	 */
	public List<Object> getDocOrEntity() {
		if (docOrEntity == null) {
			docOrEntity = new ArrayList<Object>();
		}
		return this.docOrEntity;
	}

	/**
	 * Gets the value of the name property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setName(String value) {
		this.name = value;
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
	 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Entity {

		@XmlAttribute(name = "name", required = true)
		protected String name;

		/**
		 * Gets the value of the name property.
		 *
		 * @return possible object is
		 * {@link String }
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the value of the name property.
		 *
		 * @param value allowed object is
		 *              {@link String }
		 */
		public void setName(String value) {
			this.name = value;
		}

	}

}
