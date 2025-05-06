package org.openlca.sd.xmile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmile", namespace = Xmile.NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class Xmile {

	public static final String NS = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0";

	@XmlElement(name = "header", namespace = NS)
	Header header;

	@XmlElement(name = "sim_specs", namespace = NS)
	SimSpecs simSpecs;

	@XmlElement(name = "model", namespace = NS)
	Model model;

	@XmlElementWrapper(name = "dims", namespace = NS)
	@XmlElement(name = "dim", namespace = Xmile.NS)
	List<Dim> dims;

	public static Xmile readFrom(File file) {
		try (var stream = new FileInputStream(file);
				 var buffer = new BufferedInputStream(stream)) {
			return readFrom(buffer);
		} catch (Exception e) {
			throw new RuntimeException("error reading XMILE file: " + file, e);
		}
	}

	public static Xmile readFrom(InputStream stream) {
		try {
			return JAXB.unmarshal(stream, Xmile.class);
		} catch (Exception e) {
			throw new RuntimeException("error reading XMILE stream", e);
		}
	}

	public Header header() {
		return header;
	}

	public SimSpecs simSpecs() {
		return simSpecs;
	}

	public List<Dim> dims() {
		return dims != null ? dims : Collections.emptyList();
	}

	public Model model() {
		return model;
	}
}
