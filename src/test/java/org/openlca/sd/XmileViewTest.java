package org.openlca.sd;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openlca.sd.xmile.Xmile;
import org.openlca.sd.xmile.svg.Svg;
import org.openlca.sd.xmile.svg.SvgWriter;

public class XmileViewTest {

	public static void main(String[] args) throws Exception {
		var xmile = Xmile.readFrom(new File("examples/environment.stmx"));
		var model = xmile.model();
		var view = model.views().getFirst();

		var doc = Svg.convert(view);
		Files.writeString(Paths.get("target/model.svg"), SvgWriter.toXml(doc));

	}
}
