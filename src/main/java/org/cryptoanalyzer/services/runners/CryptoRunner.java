package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public interface CryptoRunner {
    void run(CryptoOperation operation, int algorithmCode) throws IOException;
}
