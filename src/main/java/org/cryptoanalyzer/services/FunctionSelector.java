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
        output.showInputFunctionsCodeList();
        function = input.inputFunction();
    }

    public void readAlgorithm() throws IOException {
        output.showInputAlgorithmCodeList(function);
        algorithm = input.inputAlgorithm();
    }

    public int getFunction() {
        return function;
    }
    public int getAlgorithm() {
        return algorithm;
    }

}
