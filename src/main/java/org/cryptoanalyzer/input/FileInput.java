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

    /**
     * Reads the content of a file and returns it as a String to be used in encryption/decryption.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException and ApplicationExceptions If there is an error reading the file.
     */
    public String readTextToCode(Path filePath) throws IOException, ApplicationExceptions{
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
