package org.cryptoanalyzer.app;

import org.cryptoanalyzer.input.Input;
import org.cryptoanalyzer.result.Output;
import org.cryptoanalyzer.services.BasicCaesarDecoder;
import org.cryptoanalyzer.services.BasicCaesarEncoder;
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
                    case 10, 11, 12, 99 -> {
                        output.underConstruction();
                    }
                }
            }
            case 2 -> {
                switch (algorithm) {
                    case 20, 21, 22, 99 -> {
                        output.underConstruction();
                    }
                }
            }
            case 3 -> {
                switch (algorithm) {
                    case 20, 21, 22 -> {
                        output.underConstruction();
                    }
                }
            }
            case 101 -> {
                switch (algorithm) {
                    // All encode algorithms
                    case 10 -> {
                        CryptoOperation operation = new BasicCaesarEncoder();

                        output.showInputLineToCodeInfo();
                        result.setInitialLine(input.inputLineToCode());

                        output.showInputCodeKeyInfo();
                        result.setCodeKey(input.inputCodeKey());

                        result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
                        output.showResult(result);

                    }
                    case 11, 12 -> {
                        output.underConstruction();
                    }
                    // All decode algorithms
                    case 20 -> {
                        CryptoOperation operation = new BasicCaesarDecoder();

                        output.showInputLineToCodeInfo();
                        result.setInitialLine(input.inputLineToCode());

                        output.showInputCodeKeyInfo();
                        result.setCodeKey(input.inputCodeKey());

                        result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
                        output.showResult(result);
                    }
                    case 21, 22 -> {
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
