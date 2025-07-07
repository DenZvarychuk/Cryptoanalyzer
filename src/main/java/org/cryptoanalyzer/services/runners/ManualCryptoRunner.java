package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.result.ChipperData;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public class ManualCryptoRunner implements CryptoRunner {

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ChipperData chipperData = new ChipperData();

    @Override
    public void run(CryptoOperation operation, int algorithmCode) throws IOException {
        AlgorithmType algorithmType = AlgorithmType.fromCode(algorithmCode);

        consoleOutput.showInputLineToCodeInfo();
        chipperData.setInitialLine(consoleInput.inputLineToCode());

        switch (algorithmType) {
            case CAESAR_CIPHER_ENCODE, CAESAR_CIPHER_DECODE -> {
                consoleOutput.showInputCodeKeyInfo();
                chipperData.setCodeKey(consoleInput.inputCodeKey());
                chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
                consoleOutput.showResultCaesar(chipperData);
            }
            case VIGENERE_CIPHER_ENCODE, VIGENERE_CIPHER_DECODE -> {
                consoleOutput.showInputCodeWordInfo();
                chipperData.setCodeWord(consoleInput.inputCodeWord());
                chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeWord()));
                consoleOutput.showResultVigenere(chipperData);
            }
        }
    }
}
