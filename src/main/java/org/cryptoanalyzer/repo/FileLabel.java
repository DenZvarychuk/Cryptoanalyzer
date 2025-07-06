package org.cryptoanalyzer.repo;

public enum FileLabel {
    ENCRYPTED(1),
    DECRYPTED(2);

    private final int code;
    FileLabel(int code) {
        this.code = code;
    }
}
