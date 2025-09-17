package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAttribute;

public abstract class XmiStyleInfo {

	@XmlAttribute(name = "color")
	String color;

	@XmlAttribute(name = "background")
	String background;

	@XmlAttribute(name = "font_family")
	String fontFamily;

	@XmlAttribute(name = "font_size")
	String fontSize;

	@XmlAttribute(name = "font_color")
	String fontColor;

	@XmlAttribute(name = "padding")
	Integer padding;

	@XmlAttribute(name = "label_side")
	String labelSide;

	public String color() {
		return color;
	}

	public String background() {
		return background;
	}

	public String fontSize() {
		return fontSize;
	}

	public String fontFamily() {
		return fontFamily;
	}

	public String fontColor() {
		return fontColor;
	}

	public Integer padding() {
		return padding;
	}

	public String labelSide() {
		return labelSide;
	}

}
