package com.jacobschneider.engine.math.vectorcalc;

import com.jacobschneider.engine.math.Vector3;
import com.jacobschneider.engine.math.geometry.Manifold;
import com.jacobschneider.engine.math.geometry.ScalerFieldManifold;

/**
 * Skeleton implementation of scaler field
 * 
 * @author Jacob
 *
 */
public abstract class AbstractScalerField implements ScalerField {
	private static final double STEP_SIZE = 10000;
	private static final double DOUBLE_EQUALITY_TOLERANCE = Math.pow(10, -2);

	@Override
	public ScalerField add(ScalerField otherField) {
		return new SumScalerField(this, otherField);
	}
	
	@Override
	public Manifold toManifold(double potential) {
		return new ScalerFieldManifold(this, potential);
	}
	
	@Override
	public Vector3 gradientTraversal(Vector3 point, double desiredPotential) {
		double potentialDiff = desiredPotential - getValue(point);
		double dx = potentialDiff / STEP_SIZE;
		while (Math.abs(potentialDiff) >= DOUBLE_EQUALITY_TOLERANCE) {				
			point = point.add(gradient(point).multScaler(dx * potentialDiff));
			potentialDiff = desiredPotential - getValue(point);		
		}
		return point;		
	}

}