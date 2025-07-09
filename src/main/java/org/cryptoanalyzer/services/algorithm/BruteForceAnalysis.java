package org.cryptoanalyzer.services.algorithm;

import org.cryptoanalyzer.repo.Alphabet;

import java.util.HashMap;
import java.util.Map;

public class BruteForceAnalysis {

    private final Map<Character, Integer> letterCounts = new HashMap<>();
    private Map<Character, Double> expectedFrequencies = Alphabet.getCombinedFrequencies();

    private int totalLetters;

    private double bestScore = Double.MAX_VALUE;
    private int bestKey = -1;

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

    private void countLetters(char[] normalizedLine) {
        letterCounts.clear();
        for (char c : normalizedLine) {
            if (expectedFrequencies.containsKey(c)) {
                letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
            }
        }
        totalLetters = letterCounts.values().stream().mapToInt(i -> i).sum();
    }

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
