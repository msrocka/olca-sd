package org.openlca.sd.xmile.view;

import java.util.List;

import org.openlca.sd.xmile.Xmile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmiView {

	@XmlAttribute(name = "page_width")
	Integer pageWidth;

	@XmlAttribute(name = "page_height")
	Integer pageHeight;

	@XmlAttribute(name = "zoom")
	Integer zoom;

	@XmlElement(name = "stock", namespace = Xmile.NS)
	List<XmiStockView> stocks;

	@XmlElement(name = "aux", namespace = Xmile.NS)
	List<XmiAuxView> auxiliaries;

	@XmlElement(name = "text_box", namespace = Xmile.NS)
	List<XmiTextBoxView> textBoxes;

	@XmlElement(name = "flow", namespace = Xmile.NS)
	List<XmiFlowView> flows;

	@XmlElement(name = "connector", namespace = Xmile.NS)
	List<XmiConnectorView> connectors;

	public List<XmiStockView> stocks() {
		return stocks == null ? List.of() : stocks;
	}

	public List<XmiAuxView> auxiliaries() {
		return auxiliaries == null ? List.of() : auxiliaries;
	}

	public List<XmiTextBoxView> textBoxes() {
		return textBoxes == null ? List.of() : textBoxes;
	}

	public List<XmiFlowView> flows() {
		return flows == null ? List.of() : flows;
	}

	public List<XmiConnectorView> connectors() {
		return connectors == null ? List.of() : connectors;
	}

	public Integer pageWidth() {
		return pageWidth;
	}

	public Integer pageHeight() {
		return pageHeight;
	}

	public Integer zoom() {
		return zoom;
	}

}
