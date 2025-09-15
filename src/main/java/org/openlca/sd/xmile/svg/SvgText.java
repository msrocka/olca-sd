package org.openlca.sd.xmile.svg;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class SvgText {

	@XmlAttribute
	double x;

	@XmlAttribute
	double y;

	@XmlAttribute
	String fill;

	@XmlAttribute(name = "font-family")
	String fontFamily;

	@XmlAttribute(name = "font-size")
	double fontSize;

	@XmlAttribute(name = "text-anchor")
	String textAnchor;

	@XmlValue
	String content;

	public SvgText(double x, double y, String content, String fill) {
		this.x = x;
		this.y = y;
		this.content = content;
		this.fill = fill;
		this.fontFamily = "Arial";
		this.fontSize = 12.0;
		this.textAnchor = "middle";
	}

	public SvgText() {}
}
