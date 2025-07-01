package org.cryptoanalyzer.input;

import org.cryptoanalyzer.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private String line;
    private int key;

    public void readInput() throws IOException {
        try {

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Input your line");
            line = userInput.readLine();

            System.out.println("Input your key");
            key = Integer.parseInt(userInput.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getKey() {
        return key;
    }

    public String getLine() {
        return line;
    }

}
