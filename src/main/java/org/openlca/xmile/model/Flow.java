
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
@XmlRootElement(name = "flow", namespace = Xmile.NS)
public final class Flow implements Variable {

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
		@XmlElementRef(name = "multiplier", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "non_negative", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "overflow", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "leak", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElementRef(name = "leak_integers", namespace = Xmile.NS, type = JAXBElement.class),
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
	@XmlAttribute(name = "leak_start")
	protected Double leakStart;
	@XmlAttribute(name = "leak_end")
	protected Double leakEnd;

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<>();
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

	public void setName(String value) {
		this.name = value;
	}

	public AccessType getAccess() {
		return access;
	}

	public void setAccess(AccessType value) {
		this.access = value;
	}

	public boolean isAutoexport() {
		if (autoexport == null) {
			return false;
		} else {
			return autoexport;
		}
	}

	public void setAutoexport(Boolean value) {
		this.autoexport = value;
	}

	public String getSubscript() {
		return subscript;
	}

	public void setSubscript(String value) {
		this.subscript = value;
	}

	public double getLeakStart() {
		if (leakStart == null) {
			return 0.0D;
		} else {
			return leakStart;
		}
	}

	public void setLeakStart(Double value) {
		this.leakStart = value;
	}

	public double getLeakEnd() {
		if (leakEnd == null) {
			return 1.0D;
		} else {
			return leakEnd;
		}
	}

	public void setLeakEnd(Double value) {
		this.leakEnd = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
		"eqnOrMathmlOrGf"
	})
	public static class Element {

		@XmlElementRefs({
			@XmlElementRef(name = "eqn", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "gf", namespace = Xmile.NS, type = Gf.class),
			@XmlElementRef(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class),
			@XmlElementRef(name = "multiplier", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "non_negative", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "overflow", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "leak", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "leak_integers", namespace = Xmile.NS, type = JAXBElement.class)
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
		 * {@link JAXBElement }{@code <}{@link String }{@code >}
		 * {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
		 * {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
		 * {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
		 * {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
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
