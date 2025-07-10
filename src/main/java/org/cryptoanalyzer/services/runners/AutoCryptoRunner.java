package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.input.FileInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.output.FileOutput;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.result.FileData;
import org.cryptoanalyzer.result.ChipperData;
import org.cryptoanalyzer.services.algorithm.*;
import org.cryptoanalyzer.services.algorithm.BruteForceAnalysis;

import java.io.IOException;

import static org.cryptoanalyzer.repo.Alphabet.UKR_ALPHABET_LEN;
import static org.cryptoanalyzer.repo.ErrorMessages.*;

/**
 * The AutoCryptoRunner class implements the CryptoRunner interface.
 * It automates the process of encoding or decoding a file based on a given algorithm and key.
 * It handles files in both encryption and decryption modes, supporting both Caesar and Vigenère ciphers.
 *
 * This class is used to process files for the automatic encryption/decryption mode.
 */
public class AutoCryptoRunner implements CryptoRunner{

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

        fileData.setFileContent(fileInput.readTextToCode(fileData.getFilePath()));
        chipperData.setInitialLine(fileData.getFileContent());

        try {
            switch (fileData.getFileAlgorithm()){
                    case "ENCRYPT" -> {
                        fileData.parseOutputFilePathName("ENCRYPT");
                        if (fileData.getFileKey().matches("[0-9]+")){
                            operation = new CaesarEncoder();
                            processCaesar(operation);

                        } else if (fileData.getFileKey().matches("[a-zA-Z]+")) {
                            operation = new VigenereEncoder();
                            processVigenere(operation);

                        } else throw new ApplicationExceptions(INCORRECT_FILE_KEY);
                    }
                    case "DECRYPT" -> {
                        fileData.parseOutputFilePathName("DECRYPT");
                        if (fileData.getFileKey().matches("[0-9]+")){
                            operation = new CaesarDecoder();
                            processCaesar(operation);
                        } else if (fileData.getFileKey().matches("[a-zA-Z]+")) {
                            operation = new VigenereDecoder();
                            processVigenere(operation);
                        } else throw new ApplicationExceptions(INCORRECT_FILE_KEY);
                    }
                    case "BRUTE_FORCE" -> {
                        fileData.parseOutputFilePathName("BRUTE_FORCE");
                        operation = new CaesarDecoder();
                        processBruteForce(operation);
                    }
                    default -> throw new ApplicationExceptions(INCORRECT_ALGORITHM_FILENAME);
            }
        } catch (ApplicationExceptions e){
            consoleOutput.showErrorMessage(e.getMessage());
        }
    }

    private void processBruteForce(CryptoOperation operation) throws IOException{
        final BruteForceAnalysis bruteForceAnalysis = new BruteForceAnalysis();

        for (int key = 1; key < UKR_ALPHABET_LEN; key++) {
            chipperData.setCodeKey(key);
            chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
            bruteForceAnalysis.check(chipperData.getResultLine(), key);
        }

        chipperData.setCodeKey(bruteForceAnalysis.getBestKey());
        chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
        fileOutput.writeResult(chipperData.getResultLine(), fileData.getOutputFilePath());
        consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());

    }

    private void processCaesar(CryptoOperation operation) throws IOException {
        try {
            chipperData.setCodeKey(Integer.parseInt(fileData.getFileKey()));
        } catch (NumberFormatException e) {
            consoleOutput.showErrorMessage(INVALID_KEY);
        }
        chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
        fileOutput.writeResult(chipperData.getResultLine(), fileData.getOutputFilePath());
        consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
    }

    private void processVigenere(CryptoOperation operation) throws IOException {
        chipperData.setCodeWord(fileData.getFileKey());
        chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeWord()));
        fileOutput.writeResult(chipperData.getResultLine(), fileData.getOutputFilePath());
        consoleOutput.showNewFileName(fileData.getFileParentDirectory(), fileData.getOutputFileName());
    }
}
