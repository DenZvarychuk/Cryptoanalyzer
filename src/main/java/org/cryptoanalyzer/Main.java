package org.cryptoanalyzer;


import org.cryptoanalyzer.app.Application;
import org.cryptoanalyzer.services.FunctionSelector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FunctionSelector selector = new FunctionSelector();
        selector.inputFunction();

        new Application().run();

    }
}