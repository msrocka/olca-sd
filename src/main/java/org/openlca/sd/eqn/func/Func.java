package org.openlca.sd.eqn.func;

import java.util.List;

import org.openlca.sd.eqn.Cell;
import org.openlca.sd.util.Res;

public interface Func {

	Res<Cell> apply(List<Cell> args);

}
