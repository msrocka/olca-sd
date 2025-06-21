package org.openlca.sd.xmile;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiAux extends XmiEvaluatable {

	@XmlElement(name ="element", namespace = Xmile.NS)
	List<XmiElement> elements;

	public List<XmiElement> elements() {
		return elements != null ? elements : List.of();
	}
}
