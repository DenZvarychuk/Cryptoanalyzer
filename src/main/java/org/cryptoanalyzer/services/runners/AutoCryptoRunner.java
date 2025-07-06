package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public class AutoCryptoRunner implements CryptoRunner{
    @Override
    public void run(CryptoOperation operation, int algorithmTypeCode) throws IOException {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.underConstruction();
    }
}
