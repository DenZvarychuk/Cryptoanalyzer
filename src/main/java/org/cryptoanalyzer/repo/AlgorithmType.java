package org.cryptoanalyzer.repo;

public enum AlgorithmType {
    CAESAR_CIPHER_ENCODE(11,  "Шифрування Цезаря"),
    VIGENERE_CIPHER_ENCODE(12, "Шифрування Віжинера"),
    CAESAR_CIPHER_DECODE(21, "Дешифрування Цезаря"),
    VIGENERE_CIPHER_DECODE(22, "Дешифрування Віжинера");

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
