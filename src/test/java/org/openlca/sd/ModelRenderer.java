package org.openlca.sd;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import javax.imageio.ImageIO;

import org.openlca.sd.util.Res;
import org.openlca.sd.xmile.Xmile;
import org.openlca.sd.xmile.view.XmiView;
import org.openlca.sd.xmile.view.XmiViewPoint;

public class ModelRenderer {

	private final Xmile xmile;

	public ModelRenderer(Xmile xmile) {
		this.xmile = Objects.requireNonNull(xmile);
	}

	public Res<BufferedImage> render() {
		if (xmile.model() == null)
			return Res.error("no model found");
		var view = xmile.model().views().isEmpty()
			? null
			: xmile.model().views().getFirst();
		if (view == null)
			return Res.error("no view found");

		var size = estimateSizeOf(view);
		var image = new BufferedImage(
			size.x, size.y, BufferedImage.TYPE_INT_ARGB);
		var g = image.createGraphics();

		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, size.x, size.y);

		for (var f : view.flows()) {
			if (f.pts().size() < 2)
				continue;
			for (int i = 1; i < f.pts().size(); i++) {
				XmiViewPoint p0 = f.pts().get(i - 1);
				XmiViewPoint p1 = f.pts().get(i);
				g.setColor(Color.BLUE);
				g.drawLine((int) p0.x(), (int) p0.y(), (int) p1.x(), (int) p1.y());
			}
		}


		return Res.of(image);
	}


	private Point estimateSizeOf(XmiView view) {
		class MaxDim {
			double value;

			MaxDim(Integer initial, double fallback) {
				value = initial != null ? initial : fallback;
			}

			void accept(double v) {
				value = Math.max(value, v + 60);
			}

			int value() {
				return (int) Math.ceil(value);
			}
		}

		var width = new MaxDim(view.pageWidth(), 800);
		var height = new MaxDim(view.pageHeight(), 600);

		Consumer<List<? extends XmiViewPoint>> acc = list -> list.forEach(p -> {
			width.accept(p.x());
			height.accept(p.y());
		});

		acc.accept(view.stocks());
		acc.accept(view.auxiliaries());
		acc.accept(view.textBoxes());
		for (var f : view.flows()) {
			width.accept(f.x());
			height.accept(f.y());
			acc.accept(f.pts());
		}

		return new Point(width.value(), height.value());
	}


	public static void main(String[] args) throws Exception {
		var xmile = Xmile.readFrom(new File("examples/environment.stmx"));
		var image = new ModelRenderer(xmile).render().orElseThrow();
		ImageIO.write(image, "PNG", new File("target/model.png"));

	}

}
