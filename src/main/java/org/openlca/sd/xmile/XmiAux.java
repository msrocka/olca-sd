package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiAux extends XmiVariable {

	@XmlElement(name = "eqn", namespace = Xmile.NS)
	String eqn;

	public String eqn() {
		return eqn;
	}
}
