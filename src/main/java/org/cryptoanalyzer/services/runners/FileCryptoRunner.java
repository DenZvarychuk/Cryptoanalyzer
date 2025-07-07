package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.input.FileInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.output.FileOutput;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.result.FileData;
import org.cryptoanalyzer.result.ChipperData;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

import static org.cryptoanalyzer.repo.ErrorMessages.*;

public class FileCryptoRunner implements CryptoRunner{

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ChipperData chipperData = new ChipperData();
    private final FileData fileData = new FileData();
    private final FileInput fileInput = new FileInput();
    private final FileOutput fileOutput = new FileOutput();

    @Override
    public void run(CryptoOperation operation, int algorithmCode) throws IOException {
        AlgorithmType algorithmType = AlgorithmType.fromCode(algorithmCode);

        consoleOutput.showInputFilePassInfo();
        fileData.parseFileName(consoleInput.inputPath());
        fileData.parseOutputFilePathName(algorithmType);
        fileData.setFileContent(fileInput.readTextToCode(fileData.getFilePath()));
        chipperData.setInitialLine(fileData.getFileContent());

        switch (algorithmType) {
            case CAESAR_CIPHER_ENCODE, CAESAR_CIPHER_DECODE -> {
                try {
                    chipperData.setCodeKey(Integer.parseInt(fileData.getFileKey()));
                } catch (NumberFormatException e) {
                    consoleOutput.showErrorMessage(INVALID_KEY);
                }
                chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
                fileOutput.writeResult(chipperData.getResultLine(), fileData.getOutputFilePath());
                consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
            }
            case VIGENERE_CIPHER_ENCODE, VIGENERE_CIPHER_DECODE -> {
                chipperData.setCodeWord(fileData.getFileKey());
                chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeWord()));
                fileOutput.writeResult(chipperData.getResultLine(), fileData.getOutputFilePath());
                consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
            }
        }
    }
}
