package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.commons.Res;
import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.cells.Cell;

public interface Func {

	Id name();

	Res<Cell> apply(List<Cell> args);

}
