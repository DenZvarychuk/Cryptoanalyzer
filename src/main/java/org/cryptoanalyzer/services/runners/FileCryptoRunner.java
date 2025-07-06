package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.result.Result;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

public class FileCryptoRunner implements CryptoRunner{

    //TODO add possibility to read from file

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final Result result = new Result();

    @Override
    public void run(CryptoOperation operation, int algorithmTypeCode) throws IOException {

        consoleOutput.showInputFilePassInfo();
        result.setPath(consoleInput.inputPath());

        //TODO and Exception handling EMPTY_FILE, FILE_DOES_NOT_EXIST here

        System.out.println(result.getFilePath());

    }
}
