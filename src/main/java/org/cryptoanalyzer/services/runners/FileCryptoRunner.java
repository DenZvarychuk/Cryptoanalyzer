package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.input.FileInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.output.FileOutput;
import org.cryptoanalyzer.result.FileData;
import org.cryptoanalyzer.result.Result;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;
import java.nio.file.Path;

import static org.cryptoanalyzer.repo.ErrorMessages.INVALID_KEY;

public class FileCryptoRunner implements CryptoRunner{

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final Result result = new Result();
    private final FileData fileData = new FileData();
    private final FileInput fileInput = new FileInput();
    private final FileOutput fileOutput = new FileOutput();

    @Override
    public void run(CryptoOperation operation, int algorithmTypeCode) throws IOException {

        consoleOutput.showInputFilePassInfo();
        fileData.parseFileName(consoleInput.inputPath());
        fileData.parseOutputFilePathName(algorithmTypeCode / 10);
        fileData.setFileContent(fileInput.readTextToCode(fileData.getFilePath()));
        result.setInitialLine(fileData.getFileContent());

        if (algorithmTypeCode % 10 == 1) {
            try {
                result.setCodeKey(Integer.parseInt(fileData.getFileKey()));
            } catch (NumberFormatException e) {
                consoleOutput.showErrorMessage(INVALID_KEY);
            }

            result.setResultLine(operation.process(result.getInitialLine(), result.getCodeKey()));
            fileOutput.writeResult(result.getResultLine(), fileData.getOutputFilePath());
            consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
        }

        if (algorithmTypeCode % 10 == 2) {
            result.setCodeWord(fileData.getFileKey());
            result.setResultLine(operation.process(result.getInitialLine(), result.getCodeWord()));
            fileOutput.writeResult(result.getResultLine(), fileData.getOutputFilePath());
            consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
        }

    }
}
