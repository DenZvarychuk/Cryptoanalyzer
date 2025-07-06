package org.cryptoanalyzer.services.selectors;

import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.services.algorithm.*;
import org.cryptoanalyzer.services.runners.*;

public class CryptoOperationSelector {

    CryptoRunner runner;
    CryptoOperation operation;

    public CryptoRunner select(int function, int algorithm) {
        switch (function) {
            case 1, 2 -> runner = new FileCryptoRunner();
            case 3 -> runner = new BruteForceCryptoRunner();
            case 4 -> runner = new AutoCryptoRunner();
            case 101 -> runner = new ManualCryptoRunner();

        }
        switch (algorithm) {
            case 11 -> operation = new CaesarEncoder();
            case 12 -> operation = new VigenereEncoder();
            case 21 -> operation = new CaesarDecoder();
            case 22 -> operation = new VigenereDecoder();
        }

        return runner;
    }

    public CryptoOperation getOperation() {
        return operation;
    }

}