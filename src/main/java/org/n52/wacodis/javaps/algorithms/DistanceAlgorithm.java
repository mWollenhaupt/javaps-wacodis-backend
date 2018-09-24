package org.n52.wacodis.javaps.algorithms;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexInput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralOutput;
import org.n52.wacodis.javaps.io.data.binding.complex.PointBinding;

import com.vividsolutions.jts.geom.Point;

@Algorithm(
        identifier = "org.n52.wacodis.javaps.algorithms.DistanceAlgorithm",
        title = "Distance",
        abstrakt = "calculates the plane distance between two Points A and B",
        version = "0.0.1",
        storeSupported = true,
        statusSupported = true)
public class DistanceAlgorithm {
	
	private Point p1;
	private Point p2;
	
	private double distance;
	
	@Execute
	public void execute() {
		this.distance = Math.hypot((p1.getX()-p2.getX()), (p1.getY()-p2.getY()));
	}
	
	@ComplexInput(
			identifier = "p1",
			binding = PointBinding.class,
			minOccurs = 1,
            maxOccurs = 1)
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	
	@ComplexInput(
			identifier = "p2",
			binding = PointBinding.class,
			minOccurs = 1,
            maxOccurs = 1)
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	
	@LiteralOutput(identifier = "distance")
	public double getDistance() {
		return distance;
	}

}
