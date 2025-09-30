package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Id;
import org.openlca.sd.eqn.cells.Cell;
import org.openlca.util.Res;

public interface Func {

	Id name();

	Res<Cell> apply(List<Cell> args);

}
