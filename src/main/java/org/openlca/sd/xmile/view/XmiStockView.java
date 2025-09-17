package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiStockView extends XmiVariableView {

	@XmlAttribute(name = "label_side")
	String labelSide;

	@XmlAttribute(name = "width")
	Double width;

	@XmlAttribute(name = "height")
	Double height;

	public String labelSide() {
		return labelSide;
	}

	public Double width() {
		return width;
	}

	public Double height() {
		return height;
	}
}
