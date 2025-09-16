package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiStockView {

	@XmlAttribute(name = "label_side")
	String labelSide;

	@XmlAttribute(name = "x")
	double x;

	@XmlAttribute(name = "y")
	double y;

	@XmlAttribute(name = "width")
	Double width;

	@XmlAttribute(name = "height")
	Double height;

	@XmlAttribute(name = "name")
	String name;

	public String labelSide() {
		return labelSide;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public String name() {
		return name;
	}

	public Double width() {
		return width;
	}

	public Double height() {
		return height;
	}
}
