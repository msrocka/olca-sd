package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAttribute;

public sealed abstract class XmiVariable
	permits XmiAux, XmiFlow, XmiGf, XmiStock {

	@XmlAttribute(name = "name")
	String name;

	public String name() {
		return name;
	}

}
