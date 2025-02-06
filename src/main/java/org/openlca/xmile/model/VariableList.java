package org.openlca.xmile.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "variables", namespace = Xmile.NS)
public class VariableList {

	@XmlElements({
		@XmlElement(name = "stock", namespace = Xmile.NS, type = Stock.class),
		@XmlElement(name = "flow", namespace = Xmile.NS, type = Flow.class),
		@XmlElement(name = "aux", namespace = Xmile.NS, type = Aux.class),
		@XmlElement(name = "gf", namespace = Xmile.NS, type = Gf.class),
		@XmlElement(name = "group", namespace = Xmile.NS, type = Group.class),
		@XmlElement(name = "module", namespace = Xmile.NS, type = Module.class)
	})
	protected List<Variable> variables;

	public List<Variable> getVariables() {
		if (variables == null) {
			variables = new ArrayList<>();
		}
		return this.variables;
	}

}
