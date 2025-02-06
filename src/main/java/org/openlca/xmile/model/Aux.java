
package org.openlca.xmile.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "aux", namespace = Xmile.NS)
public final class Aux implements Variable {

	@XmlElements({
		@XmlElement(name = "eqn", namespace = Xmile.NS, type = Equation.class),
		@XmlElement(name = "mathml", namespace = Xmile.NS, type = String.class),
		@XmlElement(name = "units", namespace = Xmile.NS, type = String.class),
		@XmlElement(name = "doc", namespace = Xmile.NS, type = String.class),
		@XmlElement(name = "gf", namespace = Xmile.NS, type = Gf.class),
		@XmlElement(name = "dimensions", namespace = Xmile.NS, type = Dimensions.class),
		@XmlElement(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class),
		@XmlElement(name = "scale", namespace = Xmile.NS, type = Scale.class),
		@XmlElement(name = "range", namespace = Xmile.NS, type = Range.class),
		@XmlElement(name = "format", namespace = Xmile.NS, type = Format.class),
		@XmlElement(name = "element", namespace = Xmile.NS, type = AuxElement.class)
	})
	private List<Object> content;

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "access")
	private AccessType access;

	@XmlAttribute(name = "autoexport")
	private Boolean autoexport;

	@XmlAttribute(name = "subscript")
	private String subscript;

	@XmlAttribute(name = "flow_concept")
	private Boolean flowConcept;

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<>();
		}
		return this.content;
	}

	public Equation getEquation() {
		for (var obj : getContent()) {
			if (obj instanceof Equation eqn)
				return eqn;
		}
		return null;
	}

	public List<AuxElement> getElements() {
		var elements = new ArrayList<AuxElement>();
		for (var obj : getContent()) {
			if (obj instanceof AuxElement elem)
				elements.add(elem);
		}
		return elements;
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

	public boolean isFlowConcept() {
		if (flowConcept == null) {
			return false;
		} else {
			return flowConcept;
		}
	}

	public void setFlowConcept(Boolean value) {
		this.flowConcept = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class AuxElement {

		@XmlElementRefs({
			@XmlElementRef(name = "eqn", namespace = Xmile.NS, type = Equation.class),
			@XmlElementRef(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "gf", namespace = Xmile.NS, type = Gf.class),
			@XmlElementRef(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class)
		})
		protected List<Object> content;

		@XmlAttribute(name = "subscript", required = true)
		protected String subscript;

		public List<Object> getContent() {
			if (content == null) {
				content = new ArrayList<>();
			}
			return this.content;
		}

		public Equation getEquation() {
			for (var obj : getContent()) {
				if (obj instanceof Equation eqn)
					return eqn;
			}
			return null;
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
