package org.cryptoanalyzer.services.selectors;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;

import java.io.IOException;

import static org.cryptoanalyzer.repo.FunctionType.*;

/**
 * The FunctionSelector class is responsible for interacting with the user to select a function and algorithm
 * for the cryptographic process. It allows the user to choose between different available functions (e.g., encryption,
 * decryption, brute force) and algorithms (e.g., Caesar, Vigenère).
 *
 * This class retrieves the user's input for the function and algorithm to be used in subsequent operations.
 */
public class FunctionSelector {

    private int function = -1;
    private int algorithm;

    public int getFunction() {
        return function;
    }
    public int getAlgorithm() {
        return algorithm;
    }

    public void readSelection(ConsoleInput consoleInput, ConsoleOutput consoleOutput) throws IOException {
        consoleOutput.showAvailableFunctions();
        function = consoleInput.inputFunctionCode();

        if (function != AUTO_MODE.getFunctionCode() && function != EXIT.getFunctionCode()) {
            consoleOutput.showAvailableAlgorithms(function);
            algorithm = consoleInput.inputAlgorithmCode();
        } else algorithm = 0;
    }
}
