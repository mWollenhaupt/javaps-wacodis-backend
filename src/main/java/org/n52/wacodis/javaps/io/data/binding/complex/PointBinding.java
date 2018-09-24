package org.n52.wacodis.javaps.io.data.binding.complex;

import org.n52.javaps.io.complex.ComplexData;

import com.vividsolutions.jts.geom.Point;

public class PointBinding implements ComplexData<Point>{

	private static final long serialVersionUID = 1L;
	
	private Point payload;
	
	public PointBinding(Point payload) {
		this.payload = payload;
	}
	
	@Override
	public Point getPayload() {
		return payload;
	}

	@Override
	public Class<?> getSupportedClass() {
		return Point.class;
	}

}
