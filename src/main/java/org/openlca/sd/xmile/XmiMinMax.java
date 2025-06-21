package org.openlca.sd.xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiMinMax {

	@XmlAttribute(name = "min")
	double min;

	@XmlAttribute(name = "max")
	double max;

	public double min() {
		return min;
	}

	public double max() {
		return max;
	}
}
