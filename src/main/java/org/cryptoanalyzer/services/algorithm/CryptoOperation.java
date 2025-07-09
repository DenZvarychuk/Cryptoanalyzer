package org.cryptoanalyzer.services.algorithm;

/**
 * This interface defines the contract for all cryptographic operations.
 * Any class implementing this interface must provide an implementation for
 * encoding or decoding operations using either a key or a code word.
 */
public interface CryptoOperation {

    String process(String lineToCode, int codeKey);
    String process(String lineToCode, String codeWord);

}
