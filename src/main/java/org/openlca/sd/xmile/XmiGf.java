package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiGf {

	@XmlAttribute(name = "name")
	String name;

	@XmlAttribute(name = "type")
	XmiGfType type;

	@XmlElement(name = "xscale", namespace = Xmile.NS)
	XmiMinMax xscale;

	@XmlElement(name = "xpts", namespace = Xmile.NS)
	XmiPoints xpts;

	@XmlElement(name = "yscale", namespace = Xmile.NS)
	XmiMinMax yscale;

	@XmlElement(name = "ypts", namespace = Xmile.NS)
	XmiPoints ypts;

	public String name() {
		return name;
	}

	public XmiGfType type() {
		return type != null ? type : XmiGfType.CONTINUOUS;
	}

	public XmiMinMax xscale() {
		return xscale;
	}

	public XmiPoints xpts() {
		return xpts;
	}

	public XmiMinMax yscale() {
		return yscale;
	}

	public XmiPoints ypts() {
		return ypts;
	}
}
