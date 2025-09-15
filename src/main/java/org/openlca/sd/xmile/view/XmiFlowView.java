package org.openlca.sd.xmile.view;

import java.util.Collections;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiFlowView {

	@XmlAttribute(name = "x")
	double x;

	@XmlAttribute(name = "y")
	double y;

	@XmlAttribute(name = "name")
	String name;

	@XmlElementWrapper(name = "pts")
	@XmlElement(name = "pt")
	List<Pt> pts;

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public String name() {
		return name;
	}

	public List<Pt> pts() {
		return pts != null ? pts : Collections.emptyList();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Pt {

		@XmlAttribute(name = "x")
		double x;

		@XmlAttribute(name = "y")
		double y;

		public double x() {
			return x;
		}

		public double y() {
			return y;
		}
	}
}
