package com.jacobschneider.engine.math.vectorcalc;

import com.jacobschneider.engine.framework.ScalarField;
import com.jacobschneider.engine.framework.VectorField;
import com.jacobschneider.engine.math.Vector3;

/**
 * A scaler field that represents the sum of two other vector fields.
 * 
 * @author Jacob
 *
 */
public class SumScalarField extends AbstractScalarField {
	private final ScalarField a;
	private final ScalarField b;
	
	/**
	 * Creates a new vector field that represents the scaler addition
	 * of each field at every point in 3D space.
	 * @param a first scaler field to sum
	 * @param b second scaler field to sum
	 */
	public SumScalarField(ScalarField a, ScalarField b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double getValue(Vector3 point) {
		return a.getValue(point) + b.getValue(point); // linear
	}

	@Override
	public Vector3 gradient(Vector3 point) {
		return a.gradient(point).add(b.gradient(point)); // linear
	}

	@Override
	public VectorField toVectorField() {
		return new SumVectorField(a.toVectorField(), b.toVectorField());
	}



}
