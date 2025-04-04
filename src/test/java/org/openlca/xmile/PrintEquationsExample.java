package org.openlca.xmile;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.openlca.xmile.model.Aux;
import org.openlca.xmile.model.Equation;
import org.openlca.xmile.model.Flow;
import org.openlca.xmile.model.Stock;
import org.openlca.xmile.model.Variable;
import org.openlca.xmile.model.Xmile;

import jakarta.xml.bind.JAXB;

public class PrintEquationsExample {

	public static void main(String[] args) {
		var path = "/home/ms/Projects/Trea/sd-service/models/TREASoURcE - Generic model v3.0 adjusted for PySD.stmx";
		var file = new File(path);
		var xmile = JAXB.unmarshal(file, Xmile.class);
		var eqs = Collector.collectFrom(xmile);
		System.out.println("Found " + eqs.size() + " equations");
		for (var eqn : eqs) {
			System.out.println(eqn);
			System.out.println("\n\n-------------------\n\n");
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
				collect(flow.getEquation());
				for (var elem : flow.getElements()) {
					collect(elem.getEquation());
				}
			}
			if (variable instanceof Stock stock) {
				collect(stock.getEquation());
				for (var elem : stock.getElements()) {
					collect(elem.getEquation());
				}
			}
			if (variable instanceof Aux aux) {
				collect(aux.getEquation());
				for (var elem : aux.getElements()) {
					collect(elem.getEquation());
				}
			}
		}

		private void collect(Equation eqn) {
			if (eqn != null
				&& eqn.getValue() != null
				&& !eqn.getValue().isBlank()) {
				set.add(eqn.getValue().strip());
			}
		}
	}

}
