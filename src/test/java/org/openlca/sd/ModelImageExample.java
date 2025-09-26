package org.openlca.sd;

import java.io.File;

import javax.imageio.ImageIO;

import org.openlca.sd.xmile.Xmile;
import org.openlca.sd.xmile.img.ModelImage;

public class ModelImageExample {

	public static void main(String[] args) throws Exception {
		var xmile = Xmile.readFrom(new File("examples/COVID-19-Model.stmx"));
		var image = ModelImage.createFrom(xmile).orElseThrow();
		ImageIO.write(image, "png", new File("target/covid.png"));
	}

}
