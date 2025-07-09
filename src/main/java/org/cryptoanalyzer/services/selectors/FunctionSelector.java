package org.cryptoanalyzer.services.selectors;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;

import java.io.IOException;

import static org.cryptoanalyzer.repo.FunctionType.*;

public class FunctionSelector {

    private int function = -1;
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

        if (function != AUTO_MODE.getFunctionCode() && function != EXIT.getFunctionCode()) {
            consoleOutput.showAvailableAlgorithms(function);
            algorithm = consoleInput.inputAlgorithmCode();
        } else algorithm = 0;
    }
}
