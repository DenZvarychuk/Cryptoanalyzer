package org.cryptoanalyzer.repo;

public enum AlgorithmType {
    BASIC_CIPHER_ENCODE(11, "Шифрування Цезаря"),
    VIGENERE_CIPHER_ENCODE(12, "Шифрування Віжинера"),
    BASIC_CIPHER_DECODE(21, "Дешифрування Цезаря"),
    VIGENERE_CIPHER_DECODE(22, "Дешифрування Віжинера");

    private final String algorithmName;
    private final int algorithmCode;

    AlgorithmType(int algorithmCode, String algorithmName){
        this.algorithmCode = algorithmCode;
        this.algorithmName = algorithmName;
    }

    public int getAlgorithmCode() {
        return algorithmCode;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

}
