
package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "module", namespace = Xmile.NS)
public final class Module implements Variable {

	@XmlElement(name = "connect", namespace = Xmile.NS)
	private List<Connector> connectors;

	@XmlAttribute(name = "name", required = true)
	private String name;

	@XmlAttribute(name = "resource")
	private String resource;

	public List<Connector> getConnectors() {
		if (connectors == null) {
			connectors = new ArrayList<>();
		}
		return this.connectors;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String value) {
		this.resource = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Connector {

		@XmlAttribute(name = "to", required = true)
		protected String to;

		@XmlAttribute(name = "from", required = true)
		protected String from;

		public String getTo() {
			return to;
		}

		public void setTo(String value) {
			this.to = value;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String value) {
			this.from = value;
		}
	}
}
