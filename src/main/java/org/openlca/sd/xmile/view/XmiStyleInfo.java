package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAttribute;

abstract class XmiStyleInfo {

	@XmlAttribute(name = "color")
	String color;

	@XmlAttribute(name = "background")
	String background;

	@XmlAttribute(name = "font_family")
	String fontFamily;

	@XmlAttribute(name = "font_size")
	String fontSize;

	@XmlAttribute(name = "padding")
	Integer padding;

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

	public Integer padding() {
		return padding;
	}

}
