package org.cryptoanalyzer.services;


import static org.cryptoanalyzer.repo.Alphabet.BASIC_ALPHABET;

public class BasicCaesarEncode implements CryptoOperation {

    @Override
    public String process(String line, int key) {

        String lineToCode = line.toUpperCase();
        StringBuilder encodingLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            String letter = String.valueOf(lineToCode.charAt(i));
            int newIndex = (BASIC_ALPHABET.indexOf(letter) + key) % BASIC_ALPHABET.length();

            String wrappedLetter = String.valueOf(BASIC_ALPHABET.charAt(newIndex));

            encodingLine.append(wrappedLetter);
        }

        return encodingLine.toString();

    }

}
