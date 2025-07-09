package org.cryptoanalyzer.services.algorithm;

import static org.cryptoanalyzer.repo.Alphabet.*;

/**
 * This class implements the Caesar cipher decryption operation for both English and Ukrainian alphabets.
 * It decodes a given string based on the Caesar cipher algorithm using a specified key.
 */
public class CaesarDecoder implements CryptoOperation {

    @Override
    public String process(String lineToCode, int codeKey) {
        StringBuilder decodedLine = new StringBuilder();

        for (int i = 0; i < lineToCode.length(); i++) {
            char symbol = lineToCode.charAt(i);

            if (ENG_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                decodedLine.append(decodeEng(symbol, codeKey));
            } else if (UKR_ALPHABET.contains(String.valueOf(symbol).toLowerCase())) {
                decodedLine.append(decodeUkr(symbol, codeKey));
            } else decodedLine.append(symbol);

        }

        return decodedLine.toString();
    }

    private char decodeEng(char symbol, int codeKey) {
        int normalizedCodeKey = codeKey % ENG_ALPHABET_LEN == 0 ? 1 : codeKey % ENG_ALPHABET_LEN;
        int symbolInd = ENG_ALPHABET.indexOf(Character.toLowerCase(symbol));
        int newIndex = (ENG_ALPHABET_LEN + symbolInd - normalizedCodeKey) % ENG_ALPHABET_LEN;
        char wrappedSymbol = Character.isUpperCase(symbol) ? Character.toUpperCase(ENG_ALPHABET.charAt(newIndex)) : ENG_ALPHABET.charAt(newIndex);

        return wrappedSymbol;
    }

    private char decodeUkr(char symbol, int codeKey) {
        int normalizedCodeKey = codeKey % UKR_ALPHABET_LEN == 0 ? 1 : codeKey % UKR_ALPHABET_LEN;
        int symbolInd = UKR_ALPHABET.indexOf(Character.toLowerCase(symbol));
        int newIndex = (UKR_ALPHABET_LEN + symbolInd - normalizedCodeKey) % UKR_ALPHABET_LEN;
        char wrappedSymbol = Character.isUpperCase(symbol) ? Character.toUpperCase(UKR_ALPHABET.charAt(newIndex)) : UKR_ALPHABET.charAt(newIndex);

        return wrappedSymbol;

    }

    @Override
    public String process(String lineToCode, String codeWord) {
        return "";
    }

}
