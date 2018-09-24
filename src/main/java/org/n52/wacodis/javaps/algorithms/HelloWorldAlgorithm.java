package org.n52.wacodis.javaps.algorithms;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

@Algorithm(
        identifier = "org.n52.wacodis.javaps.algorithms.HelloWorldAlgorithm",
        title = "Hello World Example",
        abstrakt = "echos Hello World",
        version = "0.0.1",
        storeSupported = true,
        statusSupported = true)
public class HelloWorldAlgorithm {

    private String input;
    private String output;

    @LiteralInput(
            identifier = "INPUT",
            title = "SampleInput",
            abstrakt = "abstract SampleInput",
            minOccurs = 1,
            maxOccurs = 1)
    public void setInput(String value) {
        this.input = value;
    }	

    @Execute
    public void execute() {
        this.output = "Hello World! Your input: " + input;
    }
    
    @LiteralOutput(identifier = "OUTPUT")
    public String getOutput() {
        return this.output;
    }

}
