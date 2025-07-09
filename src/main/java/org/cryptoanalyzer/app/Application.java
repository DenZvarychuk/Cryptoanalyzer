package org.cryptoanalyzer.app;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.services.runners.CryptoRunner;
import org.cryptoanalyzer.services.selectors.CryptoOperationSelector;
import org.cryptoanalyzer.services.selectors.FunctionSelector;

import static org.cryptoanalyzer.repo.FunctionType.*;

import java.io.IOException;

public class Application {

    public void run() throws IOException {
        FunctionSelector functionSelector = new FunctionSelector();
        CryptoOperationSelector operationSelector = new CryptoOperationSelector();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ConsoleInput consoleInput = new ConsoleInput();

        consoleOutput.showGreetings();

        while (true) {
            functionSelector.readSelection(consoleInput, consoleOutput);
            if (functionSelector.getFunction() == EXIT.getFunctionCode()) break;

            CryptoRunner runner = operationSelector.select(functionSelector);
            runner.run(operationSelector.getOperation(), functionSelector.getAlgorithm());
        }

        consoleOutput.showGoodbye();

    }
}
