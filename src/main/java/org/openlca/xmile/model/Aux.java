
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "aux", namespace = Xmile.NS)
public class Aux implements Variable {

	@XmlElementRefs({
		@XmlElementRef(name = "eqn", namespace = Xmile.NS, type = Equation.class),
		@XmlElementRef(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "units", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "doc", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "gf", namespace = Xmile.NS, type = Gf.class),
		@XmlElementRef(name = "dimensions", namespace = Xmile.NS, type = Dimensions.class),
		@XmlElementRef(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class),
		@XmlElementRef(name = "scale", namespace = Xmile.NS, type = Scale.class),
		@XmlElementRef(name = "range", namespace = Xmile.NS, type = Range.class),
		@XmlElementRef(name = "format", namespace = Xmile.NS, type = Format.class),
		@XmlElementRef(name = "element", namespace = Xmile.NS, type = JAXBElement.class)
	})
	protected List<Object> content;
	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute(name = "access")
	protected AccessType access;
	@XmlAttribute(name = "autoexport")
	protected Boolean autoexport;
	@XmlAttribute(name = "subscript")
	protected String subscript;
	@XmlAttribute(name = "flow_concept")
	protected Boolean flowConcept;

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<Object>();
		}
		return this.content;
	}

	public List<Equation> getEquations() {
		var equations = new ArrayList<Equation>();
		for (var obj : getContent()) {
			if (obj instanceof Equation eqn) {
				equations.add(eqn);
			}
		}
		return equations;
	}

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
	 * Gets the value of the access property.
	 *
	 * @return possible object is
	 * {@link AccessType }
	 */
	public AccessType getAccess() {
		return access;
	}

	/**
	 * Sets the value of the access property.
	 *
	 * @param value allowed object is
	 *              {@link AccessType }
	 */
	public void setAccess(AccessType value) {
		this.access = value;
	}

	/**
	 * Gets the value of the autoexport property.
	 *
	 * @return possible object is
	 * {@link Boolean }
	 */
	public boolean isAutoexport() {
		if (autoexport == null) {
			return false;
		} else {
			return autoexport;
		}
	}

	/**
	 * Sets the value of the autoexport property.
	 *
	 * @param value allowed object is
	 *              {@link Boolean }
	 */
	public void setAutoexport(Boolean value) {
		this.autoexport = value;
	}

	/**
	 * Gets the value of the subscript property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getSubscript() {
		return subscript;
	}

	/**
	 * Sets the value of the subscript property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setSubscript(String value) {
		this.subscript = value;
	}

	/**
	 * Gets the value of the flowConcept property.
	 *
	 * @return possible object is
	 * {@link Boolean }
	 */
	public boolean isFlowConcept() {
		if (flowConcept == null) {
			return false;
		} else {
			return flowConcept;
		}
	}

	/**
	 * Sets the value of the flowConcept property.
	 *
	 * @param value allowed object is
	 *              {@link Boolean }
	 */
	public void setFlowConcept(Boolean value) {
		this.flowConcept = value;
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
	 *         &lt;element name="eqn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
	 *         &lt;element name="mathml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
	 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}gf" minOccurs="0"/&gt;
	 *         &lt;element ref="{http://docs.oasis-open.org/xmile/ns/XMILE/v1.0}event_poster" minOccurs="0"/&gt;
	 *       &lt;/choice&gt;
	 *       &lt;attribute name="subscript" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
		"eqnOrMathmlOrGf"
	})
	public static class Element {

		@XmlElementRefs({
			@XmlElementRef(name = "eqn", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "gf", namespace = Xmile.NS, type = Gf.class),
			@XmlElementRef(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class)
		})
		protected List<Object> eqnOrMathmlOrGf;
		@XmlAttribute(name = "subscript", required = true)
		protected String subscript;

		/**
		 * Gets the value of the eqnOrMathmlOrGf property.
		 *
		 * <p>
		 * This accessor method returns a reference to the live list,
		 * not a snapshot. Therefore any modification you make to the
		 * returned list will be present inside the JAXB object.
		 * This is why there is not a <CODE>set</CODE> method for the eqnOrMathmlOrGf property.
		 *
		 * <p>
		 * For example, to add a new item, do as follows:
		 * <pre>
		 *    getEqnOrMathmlOrGf().add(newItem);
		 * </pre>
		 *
		 *
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link JAXBElement }{@code <}{@link String }{@code >}
		 * {@link JAXBElement }{@code <}{@link String }{@code >}
		 * {@link Gf }
		 * {@link EventPoster }
		 */
		public List<Object> getEqnOrMathmlOrGf() {
			if (eqnOrMathmlOrGf == null) {
				eqnOrMathmlOrGf = new ArrayList<Object>();
			}
			return this.eqnOrMathmlOrGf;
		}

		/**
		 * Gets the value of the subscript property.
		 *
		 * @return possible object is
		 * {@link String }
		 */
		public String getSubscript() {
			return subscript;
		}

		/**
		 * Sets the value of the subscript property.
		 *
		 * @param value allowed object is
		 *              {@link String }
		 */
		public void setSubscript(String value) {
			this.subscript = value;
		}

	}

}
