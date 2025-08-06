package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;

public interface Func {

	Cell apply(List<Cell> args);

}
