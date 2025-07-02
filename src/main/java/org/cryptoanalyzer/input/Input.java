package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;
import org.cryptoanalyzer.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {

    private String line;
    private int[] functionAndAlgorithm = new int[2];
    private int key;
    private boolean validKey = false;

    public Result readInput(Result result) throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Input your line:");
            line = userInput.readLine();

            if (line == null || line.trim().isEmpty()) {
                result.setApplicationExceptions(new ApplicationExceptions(ErrorMessages.EMPTY_LINE));
                System.out.println(ErrorMessages.EMPTY_LINE);
            }
        } while (line == null || line.trim().isEmpty());

        while (!validKey) {
            try {
                System.out.println("Input your key");
                key = Integer.parseInt(userInput.readLine());
                validKey = true;
            } catch (NumberFormatException e) {
                result.setApplicationExceptions(new ApplicationExceptions(ErrorMessages.INVALID_KEY));
                System.out.println(ErrorMessages.INVALID_KEY);
            }
        }

        return new Result(line, key);
    }

    public int[] readFunction() throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder allFunctions = new StringBuilder();
        StringBuilder allAlgorithms = new StringBuilder();

        // Get all Functions and store chosen one from Input
        for (FunctionType function : FunctionType.values()) {
            if (function.getFunctionCode() != 101) {
                allFunctions.append(function.getFunctionCode())
                        .append(" - ")
                        .append(function.getFunctionName())
                        .append("\n");
            }
        }
        System.out.printf("Please input needed function code:\n%s", allFunctions);
        functionAndAlgorithm[0] = Integer.parseInt(userInput.readLine());

        // Get all Algorithms based on FunctionCode and store chosen one from Input
        for (AlgorithmType algorithm : AlgorithmType.values()) {
            int firstDigit = algorithm.getAlgorithmCode() / 10;

            if (functionAndAlgorithm[0] == 1 && firstDigit != 1) continue;
            if (functionAndAlgorithm[0] == 2 && firstDigit != 2) continue;
            allAlgorithms.append(algorithm.getAlgorithmCode())
                        .append(" - ")
                        .append(algorithm.getAlgorithmName())
                        .append("\n");
        }
        System.out.printf("Please input algorithm code:\n%s", allAlgorithms);
        functionAndAlgorithm[1] = Integer.parseInt(userInput.readLine());

        return functionAndAlgorithm;
    }

}
