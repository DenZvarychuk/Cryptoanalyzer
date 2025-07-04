package org.cryptoanalyzer.input;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;
import org.cryptoanalyzer.result.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.cryptoanalyzer.repo.ErrorMessages.*;


public class Input {

    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    Output output = new Output();

    public String inputLineToCode() throws ApplicationExceptions, IOException {
        String enteredLine;

        while (true) {
            try {
                boolean isValid = false;
                enteredLine = userInput.readLine();

                if (enteredLine.isEmpty() || enteredLine.equals("")) {
                    throw new ApplicationExceptions(EMPTY_LINE);
                } else break;

            } catch (ApplicationExceptions e) {
                output.showErrorMessage(e.getMessage());
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
                output.showErrorMessage(INVALID_KEY);
            }
        }

        return key;

        //TODO Logs

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
                output.showErrorMessage(INVALID_FUNCTION_CODE);
                continue;
            } catch (ApplicationExceptions e) {
                output.showErrorMessage(e.getMessage());
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
                output.showErrorMessage(INVALID_ALGORITHM_CODE);
                continue;
            } catch (ApplicationExceptions e) {
                output.showErrorMessage(e.getMessage());
            }
        }

        return algorithmCode;

        //TODO Logs

    }
}
