package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.FunctionType;
import org.cryptoanalyzer.output.ConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.cryptoanalyzer.repo.ErrorMessages.*;


public class ConsoleInput {

    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    ConsoleOutput consoleOutput = new ConsoleOutput();

    public String inputLineToCode() throws ApplicationExceptions, IOException {
        String enteredLine;

        while (true) {
            try {
                enteredLine = userInput.readLine();

                if (enteredLine.isEmpty() || enteredLine.equals("")) {
                    throw new ApplicationExceptions(EMPTY_LINE);
                } else break;

            } catch (ApplicationExceptions e) {
                consoleOutput.showErrorMessage(e.getMessage());
            }
        }

        return enteredLine;

        //TODO Logs

    }

    public int inputCodeKey() throws ApplicationExceptions, IOException {
        int key;

        while (true) {
            try {
                key = Integer.parseInt(userInput.readLine());
                break;
            } catch (NumberFormatException e) {
                consoleOutput.showErrorMessage(INVALID_KEY);
            }
        }

        return key;

        //TODO Logs

    }

    public String inputCodeWord() throws ApplicationExceptions, IOException {
        String codeWord;

        while (true) {
            try {
                codeWord = userInput.readLine();

                if (codeWord.isEmpty() || codeWord.equals("")) {
                    throw new ApplicationExceptions(EMPTY_LINE);
                } else if (!codeWord.matches("[a-zA-Z]+")) {
                    throw new ApplicationExceptions(INCORRECT_SYMBOL);
                } else break;

            } catch (ApplicationExceptions e) {
                consoleOutput.showErrorMessage(e.getMessage());
            }
        }

        return codeWord;
    }

    public int inputFunctionCode() throws ApplicationExceptions, IOException {
        int functionCode = 0;

        while (true) {
            try {
                boolean isValid = false;
                functionCode = Integer.parseInt(userInput.readLine());

                for (FunctionType functionType : FunctionType.values()) {
                    if (functionCode == functionType.getFunctionCode()) {
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) throw new ApplicationExceptions(INVALID_FUNCTION_CODE);

                break;
            } catch (NumberFormatException e) {
                consoleOutput.showErrorMessage(INVALID_FUNCTION_CODE);
            } catch (ApplicationExceptions e) {
                consoleOutput.showErrorMessage(e.getMessage());
            }
        }

        return functionCode;

        //TODO Logs

    }

    public int inputAlgorithmCode() throws ApplicationExceptions, IOException {
        int algorithmCode = 0;

        while (true) {
            try {
                boolean isValid = false;
                algorithmCode = Integer.parseInt(userInput.readLine());

                for (AlgorithmType algorithmType : AlgorithmType.values()) {
                    if (algorithmCode == algorithmType.getAlgorithmCode()) {
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) throw new ApplicationExceptions(INVALID_ALGORITHM_CODE);

                break;
            } catch (NumberFormatException e) {
                consoleOutput.showErrorMessage(INVALID_ALGORITHM_CODE);
            } catch (ApplicationExceptions e) {
                consoleOutput.showErrorMessage(e.getMessage());
            }
        }

        return algorithmCode;

        //TODO Logs

    }

    public Path inputPath() throws ApplicationExceptions, IOException {
        String src;

        while (true) {
            try {
                src = userInput.readLine().trim();

                // Path normalization step for full path
                Path path = Paths.get(src).toAbsolutePath();

                // Exception handling
                if (src.isEmpty()) {
                    throw new ApplicationExceptions(EMPTY_LINE);
                }
                if (!src.matches("^[a-zA-Z]:[\\\\/].*")
                        && !src.matches("^/.*")
                        && !src.matches("^~[/]?.*")) {
                    throw new ApplicationExceptions(INVALID_PATH);
                }
                if (!Files.exists(path)) {
                    throw new ApplicationExceptions(FILE_DOES_NOT_EXIST);
                }

                return path;  // Return the absolute file path

            } catch (ApplicationExceptions e) {
                consoleOutput.showErrorMessage(e.getMessage());
            }
        }
    }
}
