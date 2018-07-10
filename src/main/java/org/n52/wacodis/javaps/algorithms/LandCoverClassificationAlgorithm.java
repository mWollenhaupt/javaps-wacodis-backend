/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.wacodis.javaps.algorithms;

import java.util.List;
import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Algorithm(
        identifier = "de.hsbo.wacodis.land_cover_classification",
        title = "Land Cover Classification",
        abstrakt = "Perform a land cover classification for optical images.",
        version = "0.0.1",
        storeSupported = true,
        statusSupported = true)
public class LandCoverClassificationAlgorithm {

    private String opticalImagesSourceType;
    private List<String> opticalImagesSources;
    private String referenceDataType;
    private List<String> referenceData;
    private String product;

    @LiteralInput(
            identifier = "OPTICAL_IMAGES_TYPE",
            title = "Optical images source type",
            abstrakt = "The type of the source for the optical images",
            minOccurs = 1,
            maxOccurs = 1,
            defaultValue = "Sentinel-2",
            allowedValues = {"Sentinel-2", "Aerial_Image"})
    public void setOpticalImagesSourceType(String value) {
        this.opticalImagesSourceType = value;
    }

    @LiteralInput(
            identifier = "OPTICAL_IMAGES_SOURCES",
            title = "Optical images sources",
            abstrakt = "Sources for the optical images",
            minOccurs = 1,
            maxOccurs = 10,
            defaultValue = "Sentinel-2")
    public void setOpticalImagesSources(List<String> value) {
        this.opticalImagesSources = value;
    }

    @LiteralInput(
            identifier = "REFERENCE_DATA_TYPE",
            title = "Reference data type",
            abstrakt = "The type of the reference data",
            minOccurs = 1,
            maxOccurs = 1,
            defaultValue = "ATKIS",
            allowedValues = {"ATKIS", "MANUAL"})
    public void setReferenceDataType(String value) {
        this.referenceDataType = value;
    }

    @LiteralInput(
            identifier = "REFERENCE_DATA",
            title = "Reference data",
            abstrakt = "Reference data for land cover classification",
            minOccurs = 1,
            maxOccurs = 10,
            defaultValue = "Sentinel-2")
    public void setReferenceData(List<String> value) {
        this.referenceData = value;
    }

    @Execute
    public void execute() {
        String sources = String.join(",", opticalImagesSources);
        String references = String.join(",", referenceData);
        this.product = String.join("|",
                "Optical images source type:" + opticalImagesSourceType,
                "Optical images source:" + sources,
                "Reference data type:" + referenceDataType,
                "Reference data:" + references);
    }

    @LiteralOutput(identifier = "PRODUCT")
    public String getOutput() {
        return this.product;
    }

}
