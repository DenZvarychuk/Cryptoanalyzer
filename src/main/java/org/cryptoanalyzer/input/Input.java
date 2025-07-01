package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {

    private String line;
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
}
