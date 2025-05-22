package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public sealed abstract class Variable
	permits Auxil, Flow, Stock {

	@XmlAttribute(name = "name")
	String name;

	@XmlElement(name = "eqn", namespace = Xmile.NS)
	String eqn;

	public String name() {
		return name;
	}

	public String eqn() {
		return eqn;
	}
}
