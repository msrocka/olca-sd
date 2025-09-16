package org.openlca.sd.xmile.view;

import org.openlca.sd.xmile.Xmile;

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

	@XmlElement(name = "from", namespace = Xmile.NS)
	String from;

	@XmlElement(name = "to", namespace = Xmile.NS)
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
