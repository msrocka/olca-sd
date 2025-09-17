package org.openlca.sd.xmile.img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.util.Res;
import org.openlca.sd.xmile.Xmile;
import org.openlca.sd.xmile.view.XmiView;
import org.openlca.sd.xmile.view.XmiViewPoint;

public class ModelImage {

	private final Xmile xmile;
	private final XmiView view;
	private final BufferedImage image;
	private final Graphics2D g;
	private final RenderContext ctx;
	private final HashMap<Id, Point> positions = new HashMap<>();

	private ModelImage(Xmile xmile, XmiView view, BufferedImage image) {
		this.xmile = xmile;
		this.view = view;
		this.image = image;
		this.g = image.createGraphics();
		g.setRenderingHint(
			RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, image.getWidth(), image.getHeight());
		this.ctx = RenderContext.create(g, xmile);
	}

	public static Res<BufferedImage> createFrom(Xmile xmile) {
		if (xmile == null || xmile.model() == null)
			return Res.error("XMILE object does not contain a model");
		var view = xmile.model().views().isEmpty()
			? null
			: xmile.model().views().getFirst();
		if (view == null)
			return Res.error("XMILE model does not contain a view");

		try {
			var size = ImageSize.estimateFrom(view);
			var image = new BufferedImage(
				size.width(), size.height(), BufferedImage.TYPE_INT_ARGB);
			return new ModelImage(xmile, view, image).render();
		} catch (Exception e) {
			return Res.error("Failed to render model image", e);
		}
	}

	public Res<BufferedImage> render() {

		var font = new Font("Arial", Font.PLAIN, 12);
		g.setFont(font);

		for (var f : view.flows()) {

			var p = pointOf(f);
			positions.put(Id.of(f.name()), p);
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y - 5, 10, 10);

			g.setColor(Color.GRAY);
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
			var pos = pointOf(s);
			var size = ctx.boxSizeOf(s);
			if (s.width() == null || s.height() == null) {
				pos = new Point(pos.x - size.x / 2, pos.y - size.y / 2);
			}
			positions.put(
				Id.of(s.name()),
				new Point(pos.x + size.x / 2, pos.y + size.y / 2));
			g.setColor(Color.BLUE);
			g.drawRect(pos.x, pos.y, size.x, size.y);

			g.setColor(Color.GRAY);
			g.drawString(s.name(), pos.x - 20, pos.y - 15);
		}


		for (var a : view.auxiliaries()) {
			var p = pointOf(a);
			positions.put(Id.of(a.name()), p);
			g.setColor(Color.GRAY);
			g.fillRect(p.x - 2, p.y - 2, 4, 4);
			g.setColor(Color.GRAY);
			g.drawString(a.name(), p.x - 20, p.y - 15);
		}

		for (var con : view.connectors()) {
			var from = positions.get(Id.of(con.from()));
			var to = positions.get(Id.of(con.to()));
			if (from == null || to == null)
				continue;

			int mx = (from.x + to.x) / 2;
			int my = (from.y + to.y) / 2;

			int px = to.x - from.x;
			int py = to.y - from.y;

			int cx = mx + (int) (0.5 * py);
			int cy = my + (int) (0.5 * px);

			var curve = new QuadCurve2D.Double(
				from.x, from.y,
				cx, cy,
				to.x, to.y
			);

			g.setColor(Color.MAGENTA);
			g.draw(curve);
		}

		g.dispose();
		return Res.of(image);
	}


	private Point pointOf(XmiViewPoint p) {
		return new Point((int) Math.round(p.x()), (int) Math.round(p.y()));
	}

	public static void main(String[] args) throws Exception {
		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var image = ModelImage.createFrom(xmile).orElseThrow();
		ImageIO.write(image, "PNG", new File("target/model.png"));
	}

}
