package org.cryptoanalyzer.services.algorithm;

import org.cryptoanalyzer.repo.Alphabet;

import java.util.HashMap;
import java.util.Map;

/**
 * BruteForceAnalysis performs statistical analysis to determine the best key for decoding cipher text
 * by comparing it with expected letter frequencies.
 */
public class BruteForceAnalysis {

    private final Map<Character, Integer> letterCounts = new HashMap<>();
    private Map<Character, Double> expectedFrequencies = Alphabet.getCombinedFrequencies();
    private int totalLetters;
    private double bestScore = Double.MAX_VALUE;
    private int bestKey = -1;

    /**
     * Analyzes the provided result line for a given key, updating the best key if a better match is found.
     *
     * @param resultLine the decoded result line to analyze
     * @param key        the key used to decode the result line
     */
    public void check(String resultLine, int key) {
        countLetters(resultLine.toLowerCase().toCharArray());
        double score = calculateChiSquared();

        if (score < bestScore) {
            bestScore = score;
            bestKey = key;
        }

    }

    public int getBestKey() {
        return bestKey;
    }

    /**
     * Counts the occurrence of each letter in the normalized input line.
     *
     * @param normalizedLine the input line converted to a lowercase character array
     */
    private void countLetters(char[] normalizedLine) {
        letterCounts.clear();
        for (char c : normalizedLine) {
            if (expectedFrequencies.containsKey(c)) {
                letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
            }
        }
        totalLetters = letterCounts.values().stream().mapToInt(i -> i).sum();
    }

    /**
     * Calculates the Chi-Squared score between the observed letter frequencies and the expected frequencies.
     *
     * @return the Chi-Squared score
     */
    private double calculateChiSquared() {
        double score = 0.0;

        for (Map.Entry<Character, Double> entry : expectedFrequencies.entrySet()) {
            char letter = entry.getKey();
            double expectedFrequency = entry.getValue();

            double expectedCount = totalLetters * expectedFrequency / 100.0;
            int observedCount = letterCounts.getOrDefault(letter, 0);

            if (expectedCount > 0) {
                double diff = observedCount - expectedCount;
                score += (diff * diff) / expectedCount;
            }
        }

        return score;
    }

}
