package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.result.Result;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public class ManualCryptoRunner implements CryptoRunner {

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final Result result = new Result();

    @Override
    public void run(CryptoOperation operation, int algorithmCode) throws IOException {
        AlgorithmType algorithmType = AlgorithmType.fromCode(algorithmCode);

        consoleOutput.showInputLineToCodeInfo();
        result.setInitialLine(consoleInput.inputLineToCode());

        switch (algorithmType) {
            case CAESAR_CIPHER_ENCODE, CAESAR_CIPHER_DECODE -> {
                consoleOutput.showInputCodeKeyInfo();
                result.setCodeKey(consoleInput.inputCodeKey());
                result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
                consoleOutput.showResultCaesar(result);
            }
            case VIGENERE_CIPHER_ENCODE, VIGENERE_CIPHER_DECODE -> {
                consoleOutput.showInputCodeWordInfo();
                result.setCodeWord(consoleInput.inputCodeWord());
                result.setResultLine(operation.process(result.getInitialLine(), result.getCodeWord()));
                consoleOutput.showResultVigenere(result);
            }
        }
    }
}
