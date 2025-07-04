package org.cryptoanalyzer.services;

import org.cryptoanalyzer.repo.Alphabet;

import static org.cryptoanalyzer.repo.Alphabet.ALPHABET;

public class CaesarEncoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, int codeKey) {
        StringBuilder encodingLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);

            if (!ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                encodingLine.append(symbol);
            } else {
                int newIndex = (ALPHABET.length() + ALPHABET.indexOf(Character.toLowerCase(symbol)) + codeKey) % ALPHABET.length();
                char wrappedSymbol = ALPHABET.charAt(newIndex);

                if (Character.isUpperCase(symbol)) {
                    encodingLine.append(Character.toUpperCase(wrappedSymbol));
                } else encodingLine.append(wrappedSymbol);
            }
        }

        return encodingLine.toString();
    }

}
