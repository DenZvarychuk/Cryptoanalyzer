package org.cryptoanalyzer.services.algorithm;

public interface CryptoOperation {

    String process(String lineToCode, int codeKey);
    String process(String lineToCode, String codeWord);

}
