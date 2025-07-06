package org.cryptoanalyzer.services.algorithm;

import static org.cryptoanalyzer.repo.Alphabet.ENG_ALPHABET;
import static org.cryptoanalyzer.repo.Alphabet.ENG_ALPHABET_LEN;

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
