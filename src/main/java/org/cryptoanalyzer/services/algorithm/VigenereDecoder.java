package org.cryptoanalyzer.services.algorithm;

import static org.cryptoanalyzer.repo.Alphabet.*;

/**
 * This class implements the Vigenère cipher decryption algorithm.
 * It decodes a given line of text based on a Vigenère cipher and a code word.
 * The decryption shifts each letter of the text based on the corresponding letter of the code word.
 *
 * @TODO Add support for the Ukrainian alphabet (UKR_ALPHABET).
 */
public class VigenereDecoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, String codeWord) {
        StringBuilder decodedLine = new StringBuilder();

        int codeIndex = 0;

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);
            char codeWordLetter = codeWord.charAt(codeIndex % codeWord.length());

            if (!ENG_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                decodedLine.append(symbol);
            } else {
                decodedLine.append(decode(symbol, codeWordLetter));
                codeIndex++;
            }
        }

        return decodedLine.toString();
    }

    private char decode(char symbol, char codeWordLetter) {
        int codeKey = ENG_ALPHABET.indexOf(String.valueOf(codeWordLetter).toLowerCase());
        int symbolIndex = ENG_ALPHABET.indexOf(String.valueOf(symbol).toLowerCase());
        int newIndex = (ENG_ALPHABET_LEN + symbolIndex - codeKey) % ENG_ALPHABET_LEN;
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
