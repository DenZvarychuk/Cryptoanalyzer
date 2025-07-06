package org.cryptoanalyzer.services.selectors;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;

import java.io.IOException;

public class FunctionSelector {

    private int function;
    private int algorithm;

    ConsoleInput consoleInput = new ConsoleInput();
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public int getFunction() {
        return function;
    }
    public int getAlgorithm() {
        return algorithm;
    }

    public void readSelection() throws IOException {
        consoleOutput.showAvailableFunctions();
        function = consoleInput.inputFunctionCode();

        if (function != 4) {
            consoleOutput.showAvailableAlgorithms(function);
            algorithm = consoleInput.inputAlgorithmCode();
        } else algorithm = 0;
    }
}
