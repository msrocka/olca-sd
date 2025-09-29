package org.openlca.sd.eqn;

import org.openlca.sd.xmile.Xmile;
import org.openlca.util.Res;

public class TimeSeq {

	private final double start;
	private final double end;
	private final double dt;
	private double current;

	public static Res<TimeSeq> of (Xmile xmile) {
		if (xmile == null || xmile.simSpecs() == null)
			return Res.error("no sim-specs provided");
		var specs = xmile.simSpecs();
		if (specs.start() == null)
			return Res.error("no start time provided");
		if (specs.stop() == null)
			return Res.error("no end time provided");
		if (specs.dt() == null || specs.dt().value() == null)
			return Res.of(new TimeSeq(specs.start(), specs.stop()));
		var seq =  specs.dt().isReciprocal()
			? new TimeSeq(specs.start(), specs.stop(), 1 / specs.dt().value())
			: new TimeSeq(specs.start(), specs.stop(), specs.dt().value());
		return Res.of(seq);
	}

	public TimeSeq(double start, double end, double dt) {
		this.start = start;
		this.end = end;
		this.dt = dt;
		this.current = start;
	}

	public TimeSeq(double start, double end) {
		this(start, end, 1);
	}

	public boolean isFinished() {
		return current >= end;
	}

	public double next() {
		current += dt;
		return current;
	}

	public double start() {
		return start;
	}

	public double end() {
		return end;
	}

	public double dt() {
		return dt;
	}

	public double current() {
		return current;
	}
}
