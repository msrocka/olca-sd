package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiViewShape {

	@XmlAttribute(name = "type")
	String type;

	@XmlAttribute(name = "width")
	Double width;

	@XmlAttribute(name = "height")
	Double height;

	@XmlAttribute(name = "radius")
	Double radius;

	public String type() {
		return type;
	}

	public Double width() {
		return width;
	}

	public Double height() {
		return height;
	}

	public Double radius() {
		return radius;
	}
}
