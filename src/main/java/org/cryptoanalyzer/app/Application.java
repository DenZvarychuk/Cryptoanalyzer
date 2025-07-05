package org.cryptoanalyzer.app;

import org.cryptoanalyzer.services.*;

import java.io.IOException;

public class Application {

    public void run() throws IOException {

        FunctionSelector selector = new FunctionSelector();
        selector.readSelection();

        CryptoOperationSelector operationSelector = new CryptoOperationSelector();
        operationSelector.process(selector.getFunction(), selector.getAlgorithm());

    }
}
