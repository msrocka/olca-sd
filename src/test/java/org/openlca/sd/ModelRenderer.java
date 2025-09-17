package org.openlca.sd;

import java.awt.Color;
import java.awt.Font;
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

		var font = new Font("Arial", Font.PLAIN, 12);
		g.setFont(font);

		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, size.x, size.y);

		for (var f : view.flows()) {

			var p = pointOf(f);
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y - 5, 10, 10);

			g.drawString(f.name(), p.x, p.y - 10);

			if (f.pts().size() < 2)
				continue;
			for (int i = 1; i < f.pts().size(); i++) {
				var start = pointOf(f.pts().get(i - 1));
				var end = pointOf(f.pts().get(i));
				g.setColor(Color.BLUE);
				g.drawLine(start.x, start.y, end.x, end.y);
			}
		}

		for (var s : view.stocks()) {
			var p = pointOf(s);
			g.setColor(Color.GREEN);
			g.fillRect(p.x - 20, p.y - 10, 40, 20);
			g.setColor(Color.BLACK);
			g.drawString(s.name(), p.x - 20, p.y - 15);
		}

		for (var a : view.auxiliaries()) {
			var p = pointOf(a);
			g.setColor(Color.ORANGE);
			g.fillRect(p.x - 20, p.y - 10, 40, 20);
			g.setColor(Color.BLACK);
			g.drawString(a.name(), p.x - 20, p.y - 15);
		}

		g.dispose();
		return Res.of(image);
	}


	private Point pointOf(XmiViewPoint p) {
		return new Point((int) Math.round(p.x()), (int) Math.round(p.y()));
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
		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var image = new ModelRenderer(xmile).render().orElseThrow();
		ImageIO.write(image, "PNG", new File("target/model.png"));

	}

}
