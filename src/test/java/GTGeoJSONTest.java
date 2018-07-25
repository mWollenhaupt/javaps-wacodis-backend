
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.ParserConfigurationException;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.GeoJSONUtil;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import com.vividsolutions.jts.geom.Polygon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class GTGeoJSONTest {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GTGeoJSONTest.class);

    @Test
    public void testGeoJSONParsing() throws IOException, SAXException, ParserConfigurationException {
        InputStream in = ClassLoader.getSystemResourceAsStream("geojson_test.json");
        FeatureJSON geojson = new FeatureJSON();
        SimpleFeature sf = geojson.readFeature(in);

        
        Assert.assertThat(sf.getAttributeCount(), Matchers.equalTo(6)); //5 properties + geometry
        Assert.assertThat(sf.getID(), Matchers.equalTo("exampleID"));
        Assert.assertThat(sf.getAttribute("datetime").toString(), Matchers.equalTo("2018-06-12"));
        Assert.assertThat(sf.getAttribute("example:typ").toString(), Matchers.equalTo("Kreise"));
        Assert.assertThat(sf.getAttribute("example:staat").toString(), Matchers.equalTo("DE"));
        Assert.assertThat(sf.getAttribute("example:name").toString(), Matchers.equalTo("Landkreise/kreisfreie Staedte Sachsen"));
        Assert.assertThat(sf.getAttribute("example:adminEbene"), Matchers.equalTo(4L));
        Assert.assertThat(sf.getDefaultGeometry().getClass(), Matchers.typeCompatibleWith(com.vividsolutions.jts.geom.Polygon.class));

        Polygon polygon = (Polygon) sf.getDefaultGeometry();

        Assert.assertThat(polygon.getDimension(), Matchers.equalTo(2));
    }
}
