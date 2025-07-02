package org.cryptoanalyzer.repo;

public enum AlgorithmType {
    BASIC_CAESAR_ENCODE(10, "Шифрування Цезаря (класичне)"),
    BASIC_CAESAR_DECODE(20, "Дешифрування Цезаря (класичне)"),
    ADVANCED_CAESAR_ENCODE(11, "Шифруваня Цезаря (просунуте)"),
    ADVANCED_CAESAR_DECODE(21, "Дешифрування Цезаря (просунуте)"),
    VISION_CRYPTO_ENCODE(12, "Шифрування Віжинера"),
    VISION_CRYPTO_DECODE(22, "Дешифрування Віжинера"),
    AUTO_MODE(99, "Автоматичний режим (потрібний правильний неймінг файлу)");

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
