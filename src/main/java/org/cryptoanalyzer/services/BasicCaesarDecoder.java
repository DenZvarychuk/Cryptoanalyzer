package org.cryptoanalyzer.services;

import static org.cryptoanalyzer.repo.Alphabet.BASIC_ALPHABET;

public class BasicCaesarDecoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, int codeKey) {

        StringBuilder decodedLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            String letter = String.valueOf(lineToCode.charAt(i)).toUpperCase();

            if (!BASIC_ALPHABET.contains(letter)) {
                decodedLine.append(letter);
            } else {
                int newIndex = ((BASIC_ALPHABET.length() + BASIC_ALPHABET.indexOf(letter) - codeKey) % BASIC_ALPHABET.length());
                char wrappedLetter = BASIC_ALPHABET.charAt(newIndex);
                decodedLine.append(wrappedLetter);
            }
        }

        return decodedLine.toString();
    }

}
