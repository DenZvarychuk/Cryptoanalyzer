package org.cryptoanalyzer.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {

    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));


    public String inputLineToCode() throws IOException {
        return userInput.readLine();

        //TODO Exceptions and Logs

    }

    public int inputCodeKey() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exceptions and Logs

    }

    public int inputFunctionCode() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exceptions and Logs

    }

    public int inputAlgorithmCode() throws IOException {
        return Integer.parseInt(userInput.readLine());

        //TODO Exception and Logs

    }
}
