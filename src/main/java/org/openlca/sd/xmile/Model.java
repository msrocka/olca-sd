package org.openlca.sd.xmile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.FIELD)
public class Model {

	@XmlElementWrapper(name = "variables", namespace = Xmile.NS)
	@XmlElements({
		@XmlElement(name = "stock", namespace = Xmile.NS, type = Stock.class),
		@XmlElement(name = "flow", namespace = Xmile.NS, type = Flow.class),
		@XmlElement(name = "aux", namespace = Xmile.NS, type = Aux.class)
	})
	List<Variable> variables;

	public List<Variable> variables() {
		return variables == null ? Collections.emptyList() : variables;
	}

	public List<Stock> stocks() {
		return filter(Stock.class);
	}

	public List<Flow> flows() {
		return filter(Flow.class);
	}

	public List<Aux> auxs() {
		return filter(Aux.class);
	}

	private <T> List<T> filter(Class<T> type) {
		if (variables == null)
			return Collections.emptyList();
		var result = new ArrayList<T>();
		for (var v : variables) {
			if (type.isInstance(v))
				result.add(type.cast(v));
		}
		return result;
	}

}
