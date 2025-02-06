package org.openlca.xmile;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.openlca.xmile.model.Xmile;

import jakarta.xml.bind.JAXB;

public class XmileTest {

	@Test
	public void test() {
		var xmile = JAXB.unmarshal(
			new File("examples/resources-and-population.xml"), Xmile.class);
		assertEquals("Example model", xmile.getHeader().getName());
	}
}
