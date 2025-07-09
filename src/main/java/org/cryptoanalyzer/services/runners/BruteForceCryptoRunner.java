package org.cryptoanalyzer.services.runners;

import org.cryptoanalyzer.input.ConsoleInput;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.result.ChipperData;
import org.cryptoanalyzer.services.algorithm.BruteForceAnalysis;
import org.cryptoanalyzer.services.algorithm.CryptoOperation;

import java.io.IOException;

import static org.cryptoanalyzer.repo.Alphabet.*;

/**
 * The BruteForceCryptoRunner class implements the CryptoRunner interface and handles the process of brute-forcing
 * the decryption of a ciphered message using the Caesar cipher. It attempts all possible keys and selects the best one
 * based on a statistical analysis.
 *
 * This class specifically works with Caesar cipher decryption and includes functionality to perform brute force analysis
 * to find the most probable key.
 */
public class BruteForceCryptoRunner implements CryptoRunner {

    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ChipperData chipperData = new ChipperData();
    private final BruteForceAnalysis bruteForceAnalysis = new BruteForceAnalysis();

    @Override
    public void run(CryptoOperation operation, int algorithmCode) throws IOException {
        AlgorithmType algorithmType = AlgorithmType.fromCode(algorithmCode);

        consoleOutput.showInputLineToCodeInfo();
        chipperData.setInitialLine(consoleInput.inputLineToCode());

        switch (algorithmType) {
            case CAESAR_CIPHER_DECODE -> {

                for (int key = 1; key < UKR_ALPHABET_LEN; key++) {
                    chipperData.setCodeKey(key);
                    chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
                    bruteForceAnalysis.check(chipperData.getResultLine(), key);
                }

                chipperData.setCodeKey(bruteForceAnalysis.getBestKey());
                chipperData.setResultLine(operation.process(chipperData.getInitialLine(), chipperData.getCodeKey()));
                consoleOutput.showResultCaesarBrute(chipperData);

            }
            case VIGENERE_CIPHER_DECODE -> {
                ConsoleOutput consoleOutput = new ConsoleOutput();
                consoleOutput.underConstruction();
            }
        }
    }
}
