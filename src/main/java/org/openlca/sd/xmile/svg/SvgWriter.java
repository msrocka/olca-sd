package org.openlca.sd.xmile.svg;

import java.io.StringWriter;

import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class SvgWriter {

	public static String toXml(SvgDoc svg) {
		try {
			var context = JAXBContext.newInstance(SvgDoc.class);
			var marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			var writer = new StringWriter();
			marshaller.marshal(svg, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw new RuntimeException("Failed to marshal SVG to XML", e);
		}
	}

	public static String toXmlSimple(SvgDoc svg) {
		var writer = new StringWriter();
		JAXB.marshal(svg, writer);
		return writer.toString();
	}
}
