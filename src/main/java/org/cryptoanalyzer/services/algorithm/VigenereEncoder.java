package org.cryptoanalyzer.services.algorithm;

import static org.cryptoanalyzer.repo.Alphabet.*;

/**
 * This class implements the Vigenère cipher encryption algorithm.
 * It encodes a given line of text based on a Vigenère cipher and a code word.
 * Each letter in the text is shifted forward by the corresponding letter in the code word.
 *
 * @TODO Add support for the Ukrainian alphabet (UKR_ALPHABET).
 */
public class VigenereEncoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, String codeWord) {
        StringBuilder encodedLine = new StringBuilder();

        int codeIndex = 0;

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);
            char codeWordLetter = codeWord.charAt(codeIndex % codeWord.length());

            if (!ENG_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                encodedLine.append(symbol);
            } else {
                encodedLine.append(encode(symbol, codeWordLetter));
                codeIndex++;
            }
        }

        return encodedLine.toString();
    }

    private char encode(char symbol, char codeWordLetter) {
        int codeKey = ENG_ALPHABET.indexOf(String.valueOf(codeWordLetter).toLowerCase());
        int symbolIndex = ENG_ALPHABET.indexOf(String.valueOf(symbol).toLowerCase());
        int newIndex = (symbolIndex + codeKey) % ENG_ALPHABET_LEN;
        char wrappedSymbol = ENG_ALPHABET.charAt(newIndex);

        if (Character.isUpperCase(symbol)) {
            return Character.toUpperCase(wrappedSymbol);
        } else return wrappedSymbol;
    }

    @Override
    public String process(String lineToCode, int codeKey) {
        return "";
    }
}
