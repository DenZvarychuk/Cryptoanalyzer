package org.cryptoanalyzer.repo;

import java.util.HashMap;
import java.util.Map;

/**
 * The Alphabet class provides information about the English and Ukrainian alphabets, their frequencies,
 * and methods to combine the frequencies from both alphabets.
 */
public class Alphabet {

    public final static String ENG_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public final static String UKR_ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public final static int ENG_ALPHABET_LEN = ENG_ALPHABET.length();
    public final static int UKR_ALPHABET_LEN = UKR_ALPHABET.length();


    public static final Map<Character, Double> ENG_FREQUENCIES = Map.ofEntries(
            Map.entry('a', 8.17), Map.entry('b', 1.49), Map.entry('c', 2.78),
            Map.entry('d', 4.25), Map.entry('e', 12.70), Map.entry('f', 2.23),
            Map.entry('g', 2.02), Map.entry('h', 6.09), Map.entry('i', 6.97),
            Map.entry('j', 0.15), Map.entry('k', 0.77), Map.entry('l', 4.03),
            Map.entry('m', 2.41), Map.entry('n', 6.75), Map.entry('o', 7.51),
            Map.entry('p', 1.93), Map.entry('q', 0.10), Map.entry('r', 5.99),
            Map.entry('s', 6.33), Map.entry('t', 9.06), Map.entry('u', 2.76),
            Map.entry('v', 0.98), Map.entry('w', 2.36), Map.entry('x', 0.15),
            Map.entry('y', 1.97), Map.entry('z', 0.07)
    );

    public static final Map<Character, Double> UKR_FREQUENCIES = Map.ofEntries(
            Map.entry('о', 9.28), Map.entry('а', 8.34), Map.entry('е', 7.93),
            Map.entry('и', 7.02), Map.entry('н', 6.68), Map.entry('т', 6.61),
            Map.entry('і', 6.12), Map.entry('р', 5.61), Map.entry('с', 5.43),
            Map.entry('в', 5.27), Map.entry('л', 4.04), Map.entry('к', 3.48),
            Map.entry('д', 3.09), Map.entry('у', 2.59), Map.entry('м', 2.53),
            Map.entry('п', 2.49), Map.entry('я', 2.01), Map.entry('з', 1.90),
            Map.entry('б', 1.79), Map.entry('г', 1.69), Map.entry('й', 1.19),
            Map.entry('ь', 1.18), Map.entry('ч', 1.14), Map.entry('х', 1.07),
            Map.entry('ж', 0.89), Map.entry('ш', 0.80), Map.entry('ю', 0.66),
            Map.entry('ц', 0.54), Map.entry('щ', 0.43), Map.entry('є', 0.36),
            Map.entry('ф', 0.30), Map.entry('ї', 0.22), Map.entry('ґ', 0.01)
    );

    /**
     * Combines the frequencies of the English and Ukrainian alphabets into a single map.
     * This map contains frequencies for both languages.
     *
     * @return A map containing combined frequencies for both English and Ukrainian alphabets.
     */
    public static Map<Character, Double> getCombinedFrequencies() {
        Map<Character, Double> combined = new HashMap<>();
        combined.putAll(ENG_FREQUENCIES);
        combined.putAll(UKR_FREQUENCIES);
        return combined;
    }

}
