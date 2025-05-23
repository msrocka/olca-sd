package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiFlow extends XmiVariable {

	@XmlElement(name = "non_negative", namespace = Xmile.NS)
	XmiNonNegative nonNegative;

	public boolean isNonNegative() {
		return nonNegative != null;
	}
}
