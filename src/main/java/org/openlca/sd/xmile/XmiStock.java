package org.openlca.sd.xmile;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class XmiStock extends XmiEvaluatable {

	@XmlElement(name = "inflow", namespace = Xmile.NS)
	List<String> inflows;

	@XmlElement(name = "outflow", namespace = Xmile.NS)
	List<String> outflows;

	@XmlElement(name = "non_negative", namespace = Xmile.NS)
	XmiNonNegative nonNegative;

	@XmlElement(name = "element", namespace = Xmile.NS)
	List<XmlStockElement> elements;

	public List<String> inflows() {
		return inflows != null ? inflows : List.of();
	}

	public List<String> outflows() {
		return outflows != null ? outflows : List.of();
	}

	public boolean isNonNegative() {
		return nonNegative != null;
	}

	public List<XmlStockElement> elements() {
		return elements != null ? elements : List.of();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class XmlStockElement extends XmiElement {

		@XmlElement(name = "inflow", namespace = Xmile.NS)
		List<String> inflows;

		@XmlElement(name = "outflow", namespace = Xmile.NS)
		List<String> outflows;

		public List<String> inflows() {
			return inflows != null ? inflows : List.of();
		}

		public List<String> outflows() {
			return outflows != null ? outflows : List.of();
		}
	}
}
