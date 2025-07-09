package org.cryptoanalyzer.app;

import org.cryptoanalyzer.services.runners.CryptoRunner;
import org.cryptoanalyzer.services.selectors.CryptoOperationSelector;
import org.cryptoanalyzer.services.selectors.FunctionSelector;
import static org.cryptoanalyzer.repo.FunctionType.*;

import java.io.IOException;

public class Application {

    public void run() throws IOException {

        while (true) {
            FunctionSelector functionSelector = new FunctionSelector();
            functionSelector.readSelection();

            if (functionSelector.getFunction() == EXIT.getFunctionCode()) break;

            CryptoOperationSelector operationSelector = new CryptoOperationSelector();
            CryptoRunner runner = operationSelector.select(functionSelector.getFunction(), functionSelector.getAlgorithm());
            runner.run(operationSelector.getOperation(), functionSelector.getAlgorithm());
        }
    }
}
