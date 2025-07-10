package org.cryptoanalyzer.services.selectors;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.services.algorithm.*;
import org.cryptoanalyzer.services.runners.*;

import static org.cryptoanalyzer.repo.ErrorMessages.*;

/**
 * Selects the appropriate `CryptoRunner` and `CryptoOperation` based on the function and algorithm codes.
 */
public class CryptoOperationSelector {

    private CryptoRunner runner;
    private CryptoOperation operation;

    /**
     * Selects the appropriate runner and operation based on the given function and algorithm.
     *
     * @param functionSelector containing the user's function and algoruthm choice.
     * @return The selected `CryptoRunner` and 'Algorithm'.
     */
    public CryptoRunner select(FunctionSelector functionSelector) {
        switch (functionSelector.getFunction()) {
            case 1, 2 -> runner = new FileCryptoRunner();
            case 3 -> runner = new BruteForceCryptoRunner();
            case 4 -> runner = new AutoCryptoRunner();
            case 5 -> runner = new ManualCryptoRunner();

        }
        switch (functionSelector.getAlgorithm()) {
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

// Possible improvements
//
// add constructor to inject from GUI
