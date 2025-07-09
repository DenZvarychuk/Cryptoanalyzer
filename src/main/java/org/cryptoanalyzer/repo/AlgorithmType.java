package org.cryptoanalyzer.repo;

/**
 * Enum representing different cryptographic algorithms and their respective encoding/decoding operations.
 * Each algorithm has a code and a description.
 */
public enum AlgorithmType {
    CAESAR_CIPHER_ENCODE(11,  "Encode Caesar chipper"),
    VIGENERE_CIPHER_ENCODE(12, "Encode Vigenere chipper"),
    CAESAR_CIPHER_DECODE(21, "Decode Caesar chipper"),
    VIGENERE_CIPHER_DECODE(22, "Decode Vigenere chipper");

    private final String algorithmName;
    private final int algorithmCode;

    AlgorithmType(int algorithmCode, String algorithmName){
        this.algorithmCode = algorithmCode;
        this.algorithmName = algorithmName;
    }

    public static AlgorithmType fromCode(int code) {
        for (AlgorithmType type : values()){
            if (type.getAlgorithmCode() == code) {
                return type;
            }
        }
        return null;
    }

    public int getAlgorithmCode() {
        return algorithmCode;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

}
