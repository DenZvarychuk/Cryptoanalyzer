package org.cryptoanalyzer.app;

import org.cryptoanalyzer.input.Input;
import org.cryptoanalyzer.result.Output;
import org.cryptoanalyzer.services.CaesarDecoder;
import org.cryptoanalyzer.services.CaesarEncoder;
import org.cryptoanalyzer.result.Result;
import org.cryptoanalyzer.services.CryptoOperation;

import java.io.IOException;

public class Application {

    Result result = new Result("", 0);
    Input input = new Input();
    Output output = new Output();

    public void run(int function, int algorithm) throws IOException {

        switch (function) {
            case 1 -> {
                switch (algorithm) {
                    // All encode algorithms
                    case 11, 12, 99 -> {
                        output.underConstruction();
                    }
                }
            }
            case 2 -> {
                switch (algorithm) {
                    case 21, 22, 99 -> {
                        output.underConstruction();
                    }
                }
            }
            case 3 -> {
                switch (algorithm) {
                    case 21, 22 -> {
                        output.underConstruction();
                    }
                }
            }
            case 101 -> {
                switch (algorithm) {
                    // All encode algorithms
                    case 11 -> {
                        CryptoOperation operation = new CaesarEncoder();

                        output.showInputLineToCodeInfo();
                        result.setInitialLine(input.inputLineToCode());

                        output.showInputCodeKeyInfo();
                        result.setCodeKey(input.inputCodeKey());

                        result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
                        output.showResult(result);

                    }
                    case 12 -> {output.underConstruction();}
                    // All decode algorithms
                    case 21 -> {
                        CryptoOperation operation = new CaesarDecoder();

                        output.showInputLineToCodeInfo();
                        result.setInitialLine(input.inputLineToCode());

                        output.showInputCodeKeyInfo();
                        result.setCodeKey(input.inputCodeKey());

                        result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
                        output.showResult(result);
                    }
                    case 22 -> {
                        output.underConstruction();
                    }
                    // AutoMode
                    case 99 -> {
                        output.underConstruction();
                    }
                }
            }

        }
    }
}
