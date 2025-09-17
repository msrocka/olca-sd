package org.openlca.sd.xmile.view;

import org.openlca.sd.xmile.Xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiViewStyle extends XmiStyleInfo {

	@XmlElement(name = "flow", namespace = Xmile.NS)
	XmiElementStyle flowStyle;

	@XmlElement(name = "stock", namespace = Xmile.NS)
	XmiElementStyle stockStyle;

	@XmlElement(name = "aux", namespace = Xmile.NS)
	XmiElementStyle auxStyle;

	@XmlElement(name = "text_box", namespace = Xmile.NS)
	XmiElementStyle textBoxStyle;

	@XmlElement(name = "connector", namespace = Xmile.NS)
	XmiElementStyle connectorStyle;

	public XmiElementStyle flowStyle() {
		return flowStyle;
	}

	public XmiElementStyle stockStyle() {
		return stockStyle;
	}

	public XmiElementStyle auxStyle() {
		return auxStyle;
	}

	public XmiElementStyle textBoxStyle() {
		return textBoxStyle;
	}

	public XmiElementStyle connectorStyle() {
		return connectorStyle;
	}
}
