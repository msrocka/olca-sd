package org.openlca.sd.xmile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class XmileReaderTest {

	private Xmile xmile;

	@Before
	public void setup() throws IOException {
		try (var stream = getClass().getResourceAsStream("example.xml")) {
			xmile = Xmile.readFrom(stream);
		}
	}

	@Test
	public void testReadHeader() {
		var header = xmile.header();
		assertEquals("Example model", header.name());
	}
}
