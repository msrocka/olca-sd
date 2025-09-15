package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiConnectorView {

	@XmlAttribute(name = "uid")
	String uid;

	@XmlAttribute(name = "angle")
	double angle;

	@XmlElement(name = "from")
	String from;

	@XmlElement(name = "to")
	String to;

	public String uid() {
		return uid;
	}

	public double angle() {
		return angle;
	}

	public String from() {
		return from;
	}

	public String to() {
		return to;
	}
}
