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
        runner = selectRunner(functionSelector.getFunction());
        operation = selectOperation(functionSelector.getAlgorithm());

        return runner;
    }

    private CryptoRunner selectRunner(int function) {
        return switch (function) {
            case 1, 2 -> new FileCryptoRunner();
            case 3 -> new BruteForceCryptoRunner();
            case 4 -> new AutoCryptoRunner();
            case 5 -> new ManualCryptoRunner();
            default -> throw new ApplicationExceptions(UNKNOWN_FUNCTION);
        };
    }

    private CryptoOperation selectOperation(int algorithm) {
        return switch (algorithm) {
            case 11 -> new CaesarEncoder();
            case 12 -> new VigenereEncoder();
            case 21 -> new CaesarDecoder();
            case 22 -> new VigenereDecoder();
            default -> throw new ApplicationExceptions(UNKNOWN_ALGORITHM);
        };
    }

    public CryptoOperation getOperation() {
        return operation;
    }

}

// Possible improvements
//
// add constructor to inject from GUI
