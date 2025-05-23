package org.openlca.sd.xmile;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiFlow extends XmiEvaluatable {

	@XmlElement(name = "non_negative", namespace = Xmile.NS)
	XmiNonNegative nonNegative;

	@XmlElement(name = "element", namespace = Xmile.NS)
	List<XmiFlowElement> elements;

	public boolean isNonNegative() {
		return nonNegative != null;
	}

	public List<XmiFlowElement> elements() {
		return elements != null ? elements : List.of();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class XmiFlowElement extends XmiElement {

		@XmlElement(name="non_negative", namespace = Xmile.NS)
		XmiNonNegative nonNegative;

		public boolean isNonNegative() {
			return nonNegative != null;
		}
	}
}
