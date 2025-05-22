package org.openlca.sd.eqn;

import java.util.Objects;

public class LookupFunc {

	public enum Type {
		CONTINUOUS,
		EXTRAPOLATE,
		DISCRETE
	}

	private final Type type;
	private final int n;
	private final double[] xs;
	private final double[] ys;

	public LookupFunc(Type type, double[] xs, double[] ys) {
		this.type = Objects.requireNonNullElse(type, Type.EXTRAPOLATE);
		this.xs = xs != null ? xs : new double[0];
		this.ys = ys != null ? ys : new double[0];
		this.n = Math.min(this.xs.length, this.ys.length);
	}

	public LookupFunc(Type type, double start, double end, double[] ys) {
		this(type, scale(start, end, ys != null ? ys.length : 0), ys);
	}

	private static double[] scale(double start, double end, int n) {
		if (n <= 0)
			return new double[0];
		if (n == 1)
			return new double[]{(start + end) / 2};
		if (n == 2)
			return new double[]{start, end};

		double step = (end - start) / (n - 1);
		double[] xs = new double[n];
		for (int i = 0; i < n; i++) {
			xs[i] = start + i * step;
		}
		return xs;
	}

	public double get(double x) {
		if (n == 0)
			return 0;
		if (n == 1)
			return ys[0];



	}
}
