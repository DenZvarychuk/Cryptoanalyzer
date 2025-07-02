package org.cryptoanalyzer.services;

import org.cryptoanalyzer.input.Input;

import java.io.IOException;

public class FunctionSelector {

    private int function;
    private int algorithm;

    Input input = new Input();

    public void inputFunction() throws IOException {

        int[] selectorResult = input.readFunction();
        function = selectorResult[0];
        algorithm = selectorResult[1];

    }

    public int getFunction() {
        return function;
    }

    public int getAlgorithm() {
        return algorithm;
    }

}
