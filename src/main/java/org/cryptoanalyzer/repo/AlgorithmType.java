package org.cryptoanalyzer.repo;

public enum AlgorithmType {
    BASIC_CAESAR_ENCODE(10),
    BASIC_CAESAR_DECODE(11),
    ADVANCED_CAESAR_ENCODE(20),
    ADVANCED_CAESAR_DECODE(21),
    VISION_CRYPTO_ENCODE(30),
    VISION_CRYPTO_DECODE(31);

    private int algorithmCode;

    AlgorithmType(int algorithmCode){
        this.algorithmCode = algorithmCode;
    }

    public int getAlgorithmCode() {
        return algorithmCode;
    }
}
