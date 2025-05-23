package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiStock extends XmiVariable {

	@XmlElement(name = "inflow", namespace = Xmile.NS)
	String inflow;

	@XmlElement(name = "outflow", namespace = Xmile.NS)
	String outflow;

	@XmlElement(name = "non_negative", namespace = Xmile.NS)
	XmiNonNegative nonNegative;

	public String inflow() {
		return inflow;
	}

	public String outflow() {
		return outflow;
	}

	public boolean isNonNegative() {
		return nonNegative != null;
	}
}
