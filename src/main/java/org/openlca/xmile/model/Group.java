
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
@XmlRootElement(name = "group", namespace = Xmile.NS)
public final class Group implements Variable {

	@XmlElements({
		@XmlElement(name = "doc", namespace = Xmile.NS, type = String.class),
		@XmlElement(name = "entity", namespace = Xmile.NS, type = Entity.class)
	})
	private List<Object> content;

	@XmlAttribute(name = "name", required = true)
	private String name;

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<>();
		}
		return this.content;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Entity {

		@XmlAttribute(name = "name", required = true)
		protected String name;

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}
	}
}
