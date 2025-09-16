package org.openlca.sd.xmile.svg;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.xmile.view.XmiAuxView;
import org.openlca.sd.xmile.view.XmiConnectorView;
import org.openlca.sd.xmile.view.XmiFlowView;
import org.openlca.sd.xmile.view.XmiStockView;
import org.openlca.sd.xmile.view.XmiTextBoxView;
import org.openlca.sd.xmile.view.XmiView;

class Converter {

	private final XmiView view;
	private final SvgDoc doc;

	private Converter(XmiView view) {
		this.view = view;
		int width = view.pageWidth() != null ? view.pageWidth() : 800;
		int height = view.pageHeight() != null ? view.pageHeight() : 600;
		this.doc = new SvgDoc(width, height);
	}

	static SvgDoc convert(XmiView view) {
		return view != null
			? new Converter(view).convert()
			: new SvgDoc();
	}

	private SvgDoc convert() {
		for (var stock : view.stocks()) {
			stock(stock);
		}
		for (var aux : view.auxiliaries()) {
			aux(aux);
		}
		for (var textBox : view.textBoxes()) {
			textBox(textBox);
		}
		for (var flow : view.flows()) {
			flow(flow);
		}
		for (var connector : view.connectors()) {
			commector(connector);
		}
		return doc;
	}

	private void stock(XmiStockView stock) {

		if (stock == null || Id.isNil(stock.name()))
			return;

		var parts = stock.name().split("\\\\n");
		var text = new SvgText(stock.x(), stock.y(), "blue");
		int w = 0;
		int h = 16 * parts.length;
		for (int i = 0; i < parts.length; i++) {
			var span = new SvgText.Span(stock.x(), i * 12, parts[i]);
			text.addSpan(span);
			w = Math.max(w, parts[i].length() * 8);
		}
		doc.addText(text);

		var rect = new SvgRect(stock.x() - w / 2d, stock.y() - h / 2d, w, h);
		rect.stroke = "blue";
		rect.fill = "white";
		doc.addRect(rect);
	}

	private void aux(XmiAuxView aux) {
		var text = new SvgText(aux.x(), aux.y(), aux.name(), "blue");
		doc.addText(text);
	}

	private void textBox(XmiTextBoxView textBox) {
		var text = new SvgText(textBox.x() + textBox.width() / 2, textBox.y() + textBox.height() / 2,
			textBox.text(), "black");
		doc.addText(text);
	}

	private void flow(XmiFlowView flow) {
		var pts = flow.pts();
		if (pts.size() >= 2) {
			// Draw lines between points
			for (int i = 0; i < pts.size() - 1; i++) {
				var p1 = pts.get(i);
				var p2 = pts.get(i + 1);
				var line = new SvgLine(p1.x(), p1.y(), p2.x(), p2.y(), "black");
				doc.addLine(line);
			}

			// Add label at flow position
			var text = new SvgText(flow.x(), flow.y() - 10, flow.name(), "black");

			text.fontSize = 10.0;
			doc.addText(text);
		}
	}

	private void commector(XmiConnectorView connector) {
		// For now, create a simple curved path (this could be enhanced)
		// This is a placeholder - you might want to implement proper curve logic
		// based on the from/to elements and angle
		var pathData = String.format("M 100,100 Q 150,50 200,100");
		var path = new SvgPath(pathData, "gray");
		doc.addPath(path);
	}

}
