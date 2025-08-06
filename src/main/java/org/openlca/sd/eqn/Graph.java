package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private final Map<Id, Node> nodes = new HashMap<>();
	private final Map<Id, Id> edges = new HashMap<>();

	public record Node(Var var, List<Cell> values) {
		static Node of(Var var) {
			return new Node(var, new ArrayList<>());
		}
	}

	public Collection<Node> nodes() {
		return nodes.values();
	}

}
