package org.openlca.sd.xmile;

public sealed interface Variable
permits Aux, Flow, Stock {

	String name();

	String eqn();
}
