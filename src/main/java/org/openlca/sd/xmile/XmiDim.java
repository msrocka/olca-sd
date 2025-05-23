package org.openlca.sd.xmile;

import java.util.Collections;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiDim {

	@XmlAttribute(name = "name")
	String name;

	@XmlAttribute(name = "size")
	int size;

	@XmlElement(name = "elem", namespace = Xmile.NS)
	List<Elem> elems;

	public String name() {
		return name;
	}

	public int size() {
		return size;
	}

	public List<Elem> elems() {
		return elems != null ? elems : Collections.emptyList();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Elem {
		@XmlAttribute(name = "name")
		String name;

		public String name() {
			return name;
		}
	}

}
