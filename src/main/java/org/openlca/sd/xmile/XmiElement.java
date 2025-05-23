package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiElement {

	@XmlAttribute(name = "subscript")
	String subscript;

	@XmlElement(name = "eqn", namespace = Xmile.NS)
	String eqn;

	@XmlElement(name ="gf", namespace = Xmile.NS)
	XmiGf gf;

	public String subscript() {
		return subscript;
	}

	public String eqn() {
		return eqn;
	}

	public XmiGf gf() {
		return gf;
	}

}
