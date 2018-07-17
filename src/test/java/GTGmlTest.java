
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.geotools.GML;
import org.geotools.GML.Version;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class GTGmlTest {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GTGmlTest.class);

    @Test
    public void testGmlParsing() throws IOException, SAXException, ParserConfigurationException {
        InputStream in = ClassLoader.getSystemResourceAsStream("ows_test.gml");
        GML gml = new GML(Version.GML3);
        SimpleFeatureCollection fc = gml.decodeFeatureCollection(in);

        Assert.assertThat(fc.size(), Matchers.equalTo(8));

    }

}
