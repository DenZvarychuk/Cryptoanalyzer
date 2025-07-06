package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.result.FileData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import static org.cryptoanalyzer.repo.ErrorMessages.*;

public class FileInput {

    private final ConsoleOutput consoleOutput = new ConsoleOutput();

    public String readTextToCode(Path filePath) throws IOException {
        StringBuilder text = new StringBuilder();

        try (BufferedReader fileInput = new BufferedReader(new FileReader(filePath.toString()))) {

            while (fileInput.ready()) {
                text.append(fileInput.readLine() + "\n");
            }

            if (text.isEmpty()) throw new ApplicationExceptions(EMPTY_FILE);

        } catch (ApplicationExceptions e) {
            consoleOutput.showErrorMessage(e.getMessage());
        }
        return text.toString();
    }
}
