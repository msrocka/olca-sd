
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
@XmlRootElement(name = "flow", namespace = Xmile.NS)
public final class Flow implements Variable {

	@XmlElements({
		@XmlElement(name = "eqn", namespace = Xmile.NS, type = Equation.class),
		@XmlElement(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "units", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "doc", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "gf", namespace = Xmile.NS, type = Gf.class),
		@XmlElement(name = "dimensions", namespace = Xmile.NS, type = Dimensions.class),
		@XmlElement(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class),
		@XmlElement(name = "scale", namespace = Xmile.NS, type = Scale.class),
		@XmlElement(name = "range", namespace = Xmile.NS, type = Range.class),
		@XmlElement(name = "format", namespace = Xmile.NS, type = Format.class),
		@XmlElement(name = "multiplier", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "non_negative", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "overflow", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "leak", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "leak_integers", namespace = Xmile.NS, type = JAXBElement.class),
		@XmlElement(name = "element", namespace = Xmile.NS, type = FlowElement.class)
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

	@XmlAttribute(name = "leak_start")
	private Double leakStart;

	@XmlAttribute(name = "leak_end")
	private Double leakEnd;

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<>();
		}
		return this.content;
	}

	public Equation getEquation() {
		for (var obj : getContent()) {
			if (obj instanceof Equation eqn) {
				return eqn;
			}
		}
		return null;
	}

	public List<FlowElement> getElements() {
		var elements = new ArrayList<FlowElement>();
		for (var obj : getContent()) {
			if (obj instanceof FlowElement element) {
				elements.add(element);
			}
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
	public static class FlowElement {

		@XmlElementRefs({
			@XmlElementRef(name = "eqn", namespace = Xmile.NS, type = Equation.class),
			@XmlElementRef(name = "mathml", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "gf", namespace = Xmile.NS, type = Gf.class),
			@XmlElementRef(name = "event_poster", namespace = Xmile.NS, type = EventPoster.class),
			@XmlElementRef(name = "multiplier", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "non_negative", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "overflow", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "leak", namespace = Xmile.NS, type = JAXBElement.class),
			@XmlElementRef(name = "leak_integers", namespace = Xmile.NS, type = JAXBElement.class)
		})
		private List<Object> content;

		@XmlAttribute(name = "subscript", required = true)
		private String subscript;

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

		public String getSubscript() {
			return subscript;
		}

		public void setSubscript(String value) {
			this.subscript = value;
		}

	}

}
