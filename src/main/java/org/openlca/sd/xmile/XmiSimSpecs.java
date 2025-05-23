package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiSimSpecs {

	@XmlAttribute(name = "method")
	String method;

	@XmlAttribute(name = "time_units")
	String timeUnits;

	@XmlElement(name = "start", namespace = Xmile.NS)
	Double start;

	@XmlElement(name = "stop", namespace = Xmile.NS)
	Double stop;

	@XmlElement(name = "dt", namespace = Xmile.NS)
	Double dt;

	public String method() {
		return method;
	}

	public String timeUnits() {
		return timeUnits;
	}

	public Double start() {
		return start;
	}

	public Double stop() {
		return stop;
	}

	public Double dt() {
		return dt;
	}
}
