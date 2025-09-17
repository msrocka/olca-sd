package org.openlca.sd.xmile.view;

import jakarta.xml.bind.annotation.XmlAttribute;

abstract class XmiVariableView extends XmiBasicView {

	@XmlAttribute(name = "name")
	String name;

	public String name() {
		return name;
	}
}
