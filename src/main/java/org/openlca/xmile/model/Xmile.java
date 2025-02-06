
package org.openlca.xmile.model;

import java.math.BigDecimal;
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
@XmlRootElement(name = "xmile", namespace = Xmile.NS)
public class Xmile {

	public static final String NS = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0";

	@XmlAttribute(name = "version", required = true)
	protected BigDecimal version;

	@XmlElement(required = true, namespace = NS)
	protected Header header;

	@XmlElements({
		@XmlElement(name = "sim_specs", namespace = NS, type = SimSpecs.class),
		@XmlElement(name = "model_units", namespace = NS, type = ModelUnits.class),
		@XmlElement(name = "behavior", namespace = NS, type = Behavior.class),
		@XmlElement(name = "data", namespace = NS, type = Data.class),
		@XmlElement(name = "style", namespace = NS, type = Style.class),
		@XmlElement(name = "macro", namespace = NS, type = Macro.class),
		@XmlElement(name = "model", namespace = NS, type = Model.class),
		@XmlElement(name = "dimensions", namespace = NS, type = Dimensions.class)
	})
	protected List<Object> content;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header value) {
		this.header = value;
	}

	public List<Object> getContent() {
		if (content == null) {
			content = new ArrayList<>();
		}
		return this.content;
	}

	public List<Model> getModels() {
		List<Model> models = new ArrayList<>();
		for (Object obj : content) {
			if (obj instanceof Model) {
				models.add((Model) obj);
			}
		}
		return models;
	}

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal value) {
		this.version = value;
	}


	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
		"dim"
	})
	public static class Dimensions {

		@XmlElement(namespace = NS)
		protected List<Dim> dim;

		public List<Dim> getDim() {
			if (dim == null) {
				dim = new ArrayList<>();
			}
			return this.dim;
		}


		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = {
			"elem"
		})
		public static class Dim {

			@XmlElement(namespace = NS)
			protected List<Elem> elem;
			@XmlAttribute(name = "name", required = true)
			protected String name;
			@XmlAttribute(name = "size")
			protected Integer size;

			public List<Elem> getElem() {
				if (elem == null) {
					elem = new ArrayList<>();
				}
				return this.elem;
			}

			public String getName() {
				return name;
			}

			public void setName(String value) {
				this.name = value;
			}

			public Integer getSize() {
				return size;
			}

			public void setSize(Integer value) {
				this.size = value;
			}


			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "")
			public static class Elem {

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
	}
}
