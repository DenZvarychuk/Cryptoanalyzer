package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public class BruteForceCryptoRunner implements CryptoRunner {

    //TODO add possibility to read from file and auto-decide the chipper

    @Override
    public void run(CryptoOperation operation, int algorithmCode) throws IOException {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.underConstruction();
    }
}
