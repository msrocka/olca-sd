package org.openlca.sd.xmile.svg;

import org.openlca.sd.xmile.view.XmiAuxView;
import org.openlca.sd.xmile.view.XmiConnectorView;
import org.openlca.sd.xmile.view.XmiFlowView;
import org.openlca.sd.xmile.view.XmiStockView;
import org.openlca.sd.xmile.view.XmiTextBoxView;
import org.openlca.sd.xmile.view.XmiView;

class Converter {

	private final XmiView view;

	private Converter(XmiView view) {
		this.view = view;
	}

	static SvgDoc convert(XmiView view) {
		return view != null
			? new Converter(view).convert()
			: new SvgDoc();
	}

	private SvgDoc convert() {
		var svg = new SvgDoc();
		for (var stock : view.stocks()) {
			convertStock(svg, stock);
		}
		for (var aux : view.auxiliaries()) {
			convertAux(svg, aux);
		}
		for (var textBox : view.textBoxes()) {
			convertTextBox(svg, textBox);
		}
		for (var flow : view.flows()) {
			convertFlow(svg, flow);
		}
		for (var connector : view.connectors()) {
			convertConnector(svg, connector);
		}
		return svg;
	}

	private static void convertStock(SvgDoc svg, XmiStockView stock) {
		// Default stock size if not specified
		double width = 60;
		double height = 30;

		// Create blue rectangle
		var rect = new SvgRect(
			stock.x() - width / 2, stock.y() - height / 2, width, height);
		rect.stroke = "blue";
		rect.fill = "white";
		svg.addRect(rect);

		// Add label
		var text = new SvgText(stock.x(), stock.y() + 5, stock.name().replaceAll("\\n", " "), "blue");
		svg.addText(text);
	}

	private static void convertAux(SvgDoc svg, XmiAuxView aux) {
		var text = new SvgText(aux.x(), aux.y(), aux.name(), "blue");
		svg.addText(text);
	}

	private static void convertTextBox(SvgDoc svg, XmiTextBoxView textBox) {
		var text = new SvgText(textBox.x() + textBox.width() / 2, textBox.y() + textBox.height() / 2,
			textBox.text(), "black");
		svg.addText(text);
	}

	private static void convertFlow(SvgDoc svg, XmiFlowView flow) {
		var pts = flow.pts();
		if (pts.size() >= 2) {
			// Draw lines between points
			for (int i = 0; i < pts.size() - 1; i++) {
				var p1 = pts.get(i);
				var p2 = pts.get(i + 1);
				var line = new SvgLine(p1.x(), p1.y(), p2.x(), p2.y(), "black");
				svg.addLine(line);
			}

			// Add label at flow position
			var text = new SvgText(flow.x(), flow.y() - 10, flow.name(), "black");
			text.fontSize = 10.0;
			svg.addText(text);
		}
	}

	private static void convertConnector(SvgDoc svg, XmiConnectorView connector) {
		// For now, create a simple curved path (this could be enhanced)
		// This is a placeholder - you might want to implement proper curve logic
		// based on the from/to elements and angle
		var pathData = String.format("M 100,100 Q 150,50 200,100");
		var path = new SvgPath(pathData, "gray");
		svg.addPath(path);
	}

}
