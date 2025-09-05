package org.openlca.sd;

import java.io.File;

import org.openlca.sd.eqn.Vars;
import org.openlca.sd.xmile.Xmile;

public class VarsGraph {

	public static void main(String[] args) {
		var xmile = Xmile.readFrom(new File("examples/treasource-model.stmx"));
		var vars = Vars.readFrom(xmile).orElseThrow();

		System.out.println("digraph g {");
		for (var v : vars) {
			for (var dep : v.dependencies()) {
				System.out.printf("  \"%s\" -> \"%s\";%n", dep.value(), v.name().value());
			}
		}
		System.out.println("}");

	}

}
