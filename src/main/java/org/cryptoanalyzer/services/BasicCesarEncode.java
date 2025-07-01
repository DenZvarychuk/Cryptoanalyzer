package org.cryptoanalyzer.services;


import org.cryptoanalyzer.result.Result;

import static org.cryptoanalyzer.repo.Alphabet.BASIC_ALPHABET;

public class BasicCesarEncode {

    public String encode(String line, int key) {

        String lineToCode = line.toUpperCase();

        StringBuilder encodingLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            String letter = String.valueOf(lineToCode.charAt(i));
            String wrappedLetter = String.valueOf(BASIC_ALPHABET.charAt((BASIC_ALPHABET.indexOf(letter) + key) % BASIC_ALPHABET.length()));
            encodingLine.append(wrappedLetter);
        }

        return encodingLine.toString();

    }

}
