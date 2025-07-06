package org.cryptoanalyzer.services.algorithm;

import static org.cryptoanalyzer.repo.Alphabet.*;

public class CaesarEncoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, int codeKey) {
        StringBuilder encodedLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);

            if (ENG_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                encodedLine.append(encodeEng(symbol, codeKey));
            } else if (UKR_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                encodedLine.append(encodeUkr(symbol, codeKey));
            } else encodedLine.append(symbol);

        }

        return encodedLine.toString();
    }

    private char encodeEng(char symbol, int codeKey) {
        int symbolIndex = ENG_ALPHABET.indexOf(Character.toLowerCase(symbol));
        int newIndex = (ENG_ALPHABET_LEN + symbolIndex + (codeKey % ENG_ALPHABET_LEN)) % ENG_ALPHABET_LEN;
        char wrappedSymbol = ENG_ALPHABET.charAt(newIndex);

        if (Character.isUpperCase(symbol)) {
            return Character.toUpperCase(wrappedSymbol);
        } else return wrappedSymbol;
    }

    private char encodeUkr(char symbol, int codeKey) {
        int symbolIndex = UKR_ALPHABET.indexOf(Character.toLowerCase(symbol));
        int newIndex = (UKR_ALPHABET_LEN + symbolIndex + (codeKey % UKR_ALPHABET_LEN)) % UKR_ALPHABET_LEN;
        char wrappedSymbol = UKR_ALPHABET.charAt(newIndex);

        if (Character.isUpperCase(symbol)) {
            return Character.toUpperCase(wrappedSymbol);
        } else return wrappedSymbol;
    }

    @Override
    public String process(String lineToCode, String codeWord) {
        return "";
    }
}
