package org.cryptoanalyzer.services;

import static org.cryptoanalyzer.repo.Alphabet.ALPHABET;

public class CaesarDecoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, int codeKey) {
        StringBuilder decodedLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);

            if (!ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                decodedLine.append(symbol);
            } else {
                int newIndex = (ALPHABET.length() + ALPHABET.indexOf(Character.toLowerCase(symbol)) - codeKey) % ALPHABET.length();
                char wrappedSymbol = ALPHABET.charAt(newIndex);

                if (Character.isUpperCase(symbol)) {
                    decodedLine.append(Character.toUpperCase(wrappedSymbol));
                } else decodedLine.append(wrappedSymbol);
            }
        }

        return decodedLine.toString();
    }

}
