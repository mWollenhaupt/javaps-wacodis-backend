/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.wacodis.javaps.io.data.binding.complex;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.n52.javaps.io.complex.ComplexData;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class FeatureCollectionBinding implements ComplexData<SimpleFeatureCollection> {

    private static final long serialVersionUID = 1626429242623057672L;

    protected transient SimpleFeatureCollection simpleFeatureCollection;

    public FeatureCollectionBinding(SimpleFeatureCollection payload) {
        this.simpleFeatureCollection = payload;
    }

    @Override
    public SimpleFeatureCollection getPayload() {
        return simpleFeatureCollection;
    }

    @Override
    public Class<?> getSupportedClass() {
        return SimpleFeatureCollection.class;
    }

}
