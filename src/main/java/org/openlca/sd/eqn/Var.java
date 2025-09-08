package org.openlca.sd.eqn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public sealed interface Var {

	Id name();

	Cell def();

	List<Cell> values();

	default void pushValue(Cell cell) {
		values().add(cell);
	}

	default Cell value() {
		return values().isEmpty()
			? def()
			: values().getLast();
	}

	record Aux(Id name, Cell def, List<Cell> values) implements Var {

		public Aux {
			Objects.requireNonNull(name);
			Objects.requireNonNull(def);
			Objects.requireNonNull(values);
		}

		public Aux(Id name, Cell cell) {
			this(name, cell, new ArrayList<>());
		}

	}

	record Rate(Id name, Cell def, List<Cell> values) implements Var {

		public Rate {
			Objects.requireNonNull(name);
			Objects.requireNonNull(def);
			Objects.requireNonNull(values);
		}

		public Rate(Id name, Cell cell) {
			this(name, cell, new ArrayList<>());
		}

	}

	record Stock(
		Id name, Cell def, List<Id> inFlows, List<Id> outFlows, List<Cell> values
	) implements Var {

		public Stock {
			Objects.requireNonNull(name);
			Objects.requireNonNull(def);
			Objects.requireNonNull(inFlows);
			Objects.requireNonNull(outFlows);
			Objects.requireNonNull(values);
		}

		public Stock(Id name, Cell cell, List<Id> inFlows, List<Id> outFlows) {
			this(name, cell, inFlows, outFlows, new ArrayList<>());
		}

	}
}
