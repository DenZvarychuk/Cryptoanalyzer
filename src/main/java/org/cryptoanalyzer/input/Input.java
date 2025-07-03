package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {

    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));


    public String readLine() throws IOException {
        return userInput.readLine();

        //TODO Exceptions and Logs

    }

    public int readKey() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exceptions and Logs

    }

    public int inputFunction() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exceptions and Logs

    }

    public int inputAlgorithm() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exception and Logs

    }
}
