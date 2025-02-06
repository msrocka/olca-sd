package org.openlca.xmile.model;

public sealed interface Variable
	permits Aux, Flow, Gf, Group, Module, Stock {

	public String getName();

}
