package org.cryptoanalyzer.services;

import org.cryptoanalyzer.input.Input;
import org.cryptoanalyzer.result.Output;
import org.cryptoanalyzer.result.Result;

import java.io.IOException;

public class CryptoOperationSelector {

    Result result = new Result("", 0);
    Input input = new Input();
    Output output = new Output();

    public void process(int function, int algorithm) throws IOException {

        switch (function) {
            case 1 -> {
                switch (algorithm) {
                    // All encode algorithms
                    case 11, 12 -> {
                        output.underConstruction();
                    }
                }
            }
            case 2, 3 -> {
                switch (algorithm) {
                    case 21, 22 -> {
                        output.underConstruction();
                    }
                }
            }
            case 4 -> {
                output.underConstruction();
            }
            case 101 -> {
                switch (algorithm) {
                    // All encode algorithms
                    case 11 -> handleManualCipher(new CaesarEncoder(), algorithm % 10);
                    case 12 -> handleManualCipher(new VigenereEncoder(), algorithm % 10);
                    // All decode algorithms
                    case 21 -> handleManualCipher(new CaesarDecoder(), algorithm % 10);
                    case 22 -> handleManualCipher(new VigenereDecoder(), algorithm % 10);
                }
            }

        }

    }

    private void handleManualCipher(CryptoOperation operation, int algorithmTypeCode) throws IOException {
        output.showInputLineToCodeInfo();
        result.setInitialLine(input.inputLineToCode());

        if (algorithmTypeCode == 1) {
            output.showInputCodeKeyInfo();
            result.setCodeKey(input.inputCodeKey());

            result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
            output.showResultCaesar(result);
        }

        if (algorithmTypeCode == 2) {
            output.showInputCodeWordInfo();
            result.setCodeWord(input.inputCodeWord());

            result.setResultLine(operation.process(result.getInitialLine(), result.getCodeWord()));
            output.showResultVigenere(result);
        }
    }
}
