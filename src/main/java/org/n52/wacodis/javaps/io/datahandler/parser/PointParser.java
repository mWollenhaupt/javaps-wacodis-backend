package org.n52.wacodis.javaps.io.datahandler.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.n52.javaps.annotation.Properties;
import org.n52.javaps.description.TypedProcessInputDescription;
import org.n52.javaps.io.AbstractPropertiesInputOutputHandler;
import org.n52.javaps.io.Data;
import org.n52.javaps.io.DecodingException;
import org.n52.javaps.io.InputHandler;
import org.n52.shetland.ogc.wps.Format;
import org.n52.wacodis.javaps.io.data.binding.complex.PointBinding;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

@Properties(defaultPropertyFileName = "point.properties")
public class PointParser extends AbstractPropertiesInputOutputHandler implements InputHandler {

	public PointParser() {
		super();
		addSupportedBinding(PointBinding.class);
	}
	
	// Processes two by a whitespace separated values to a point
	@Override
	public PointBinding parse(TypedProcessInputDescription<?> description, InputStream input, Format format)
			throws IOException, DecodingException {

		GeometryFactory factory = new GeometryFactory();
		
		byte[] buffer = new byte[1024];
	    StringBuilder stringBuilder = new StringBuilder();
	    int length = 0;
	    while ((length = input.read(buffer)) >= 0) {
	        stringBuilder.append(new String(Arrays.copyOfRange(buffer, 0, length), "UTF-8"));
	    }
		String[] data = stringBuilder.toString().split(" ");
		return new PointBinding(factory.createPoint(new Coordinate(Double.parseDouble(data[0]), Double.parseDouble(data[1]))));
	}

}
