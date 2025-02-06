package org.openlca.xmile;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openlca.xmile.model.Equation;
import org.openlca.xmile.model.Flow;
import org.openlca.xmile.model.Variable;
import org.openlca.xmile.model.Xmile;

import jakarta.xml.bind.JAXB;

public class PrintEquationsExample {

	public static void main(String[] args) {
		var file = new File("target/generic-plastic-case.xml");
		var xmile = JAXB.unmarshal(file, Xmile.class);
		var eqs = Collector.collectFrom(xmile);
		System.out.println("Found " + eqs.size() + " equations");
		for (var eqn : eqs) {
			System.out.println(eqn);
		}
	}

	private record Collector(Set<String> set) {

		static Set<String> collectFrom(Xmile xmile) {
			var collector = new Collector(new HashSet<>());
			for (var model : xmile.getModels()) {
				for (var variable : model.getVariables()) {
					collector.collect(variable);
				}
			}
			return collector.set;
		}

		private void collect(Variable variable) {
			if (variable instanceof Flow flow) {
				collect(flow.getEquations());
			}
		}

		private void collect(List<Equation> equations) {
			for (var eq : equations) {
				if (eq.getValue() != null) {
					set.add(eq.getValue().strip());
				}
			}
		}
	}

}
