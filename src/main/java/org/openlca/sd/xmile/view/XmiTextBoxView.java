package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiTextBoxView {

	@XmlAttribute(name = "uid")
	String uid;

	@XmlAttribute(name = "x")
	double x;

	@XmlAttribute(name = "y")
	double y;

	@XmlAttribute(name = "width")
	double width;

	@XmlAttribute(name = "height")
	double height;

	@XmlValue
	String text;

	public String uid() {
		return uid;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double width() {
		return width;
	}

	public double height() {
		return height;
	}

	public String text() {
		return text;
	}
}
