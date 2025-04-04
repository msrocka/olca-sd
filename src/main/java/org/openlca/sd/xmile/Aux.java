package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Aux implements Variable {

	@XmlAttribute(name = "name")
	String name;

	@XmlElement(name = "eqn", namespace = Xmile.NS)
	String eqn;

	@Override
	public String name() {
		return name;
	}

	@Override
	public String eqn() {
		return eqn;
	}
}
