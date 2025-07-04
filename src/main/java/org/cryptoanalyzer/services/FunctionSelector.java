package org.cryptoanalyzer.services;

import org.cryptoanalyzer.input.Input;
import org.cryptoanalyzer.result.Output;

import java.io.IOException;

public class FunctionSelector {

    private int function;
    private int algorithm;

    Input input = new Input();
    Output output = new Output();

    public void readFunction() throws IOException {
        output.showAvailableFunctions();
        function = input.inputFunctionCode();
    }

    public void readAlgorithm() throws IOException {
        output.showAvailableAlgorithms(function);
        algorithm = input.inputAlgorithmCode();
    }

    public int getFunction() {
        return function;
    }
    public int getAlgorithm() {
        return algorithm;
    }

}
