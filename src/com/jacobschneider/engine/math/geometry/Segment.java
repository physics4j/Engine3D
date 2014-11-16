package com.jacobschneider.engine.math.geometry;

import com.jacobschneider.engine.math.Vector3;

/**
 * A line segment completely defined by two points a and b.
 * 
 * @author Jacob
 *
 */
public class Segment {
	public final Vector3 a;
	public final Vector3 b;

	public Segment(Vector3 a, Vector3 b) {
		this.a = a;
		this.b = b;
	}		
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Segment)) {
			return false;
		}
		Segment otherSeg = (Segment) o;
		if (otherSeg == this) {
			return true;
		}
		if (!(a.equals(otherSeg.a) || a.equals(otherSeg.b))) {
			return false;
		}
		if (!(b.equals(otherSeg.a) || b.equals(otherSeg.b))) {
			return false;
		}
		return true;	
	}
	@Override
	public int hashCode() {
		return  a.hashCode() * b.hashCode(); // order of each point does not matter
	}
	
	@Override
	public String toString() {
		return "First point of segment: \n" + a.toString() + "\nSecond point of segment:\n " + b.toString();
	}
}
