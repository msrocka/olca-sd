package org.openlca.sd;

import java.io.File;

import org.openlca.sd.xmile.Xmile;

public class XmileViewTest {

	public static void main(String[] args) {
		var xmile  = Xmile.readFrom(new File("examples/environment.stmx"));
		var model = xmile.model();
		var views = model.views();
		System.out.println("Views: " + views.size());
	}
}
