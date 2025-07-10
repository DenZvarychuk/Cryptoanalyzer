package org.cryptoanalyzer.output;

import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;
import org.cryptoanalyzer.result.ChipperData;

/**
 * ConsoleOutput is responsible for displaying information to the user in the console.
 * It provides various methods to show messages related to the cryptographic operations, such as input prompts,
 * result displays, error messages, and status updates.
 */
public class ConsoleOutput {

    public void showInputLineToCodeInfo(){System.out.print("Input your line: \n-> ");}

    public void showInputCodeKeyInfo(){System.out.print("Input your key:\n-> ");}

    public void showInputCodeWordInfo() {System.out.print("Input your code word:\n-> ");}

    public void showInputFilePassInfo() {
        System.out.print("Your file should have propper file naming!\nCorrect name: fileNam [OPERATION] key.fileExtension\nPlease input pass to your file\n-> ");
    }

    public void showAvailableFunctions() {
        StringBuilder optionList  = new StringBuilder();
        for (FunctionType function : FunctionType.values()) {
                optionList .append(function.getFunctionCode())
                        .append(" - ")
                        .append(function.getFunctionName())
                        .append("\n");
        }
        System.out.print(String.format("Please input function code:\n%s-> ", optionList ));
    }

    public void showAvailableAlgorithms(int function) {
        StringBuilder optionList  = new StringBuilder();
        for (AlgorithmType algorithm : AlgorithmType.values()) {
            int algorithmFunctionCode = algorithm.getAlgorithmCode() / 10;

            if (function == 1 && algorithmFunctionCode == 2) continue;
            if (function == 2 && algorithmFunctionCode == 1) continue;
            if (function == 3 && algorithmFunctionCode != 2) continue;
            optionList .append(algorithm.getAlgorithmCode())
                    .append(" - ")
                    .append(algorithm.getAlgorithmName())
                    .append("\n");
        }
        System.out.print(String.format("Please input algorithm code:\n%s-> ", optionList));
    }

    public void showResultCaesar(ChipperData chipperData) {
        System.out.print(String.format("Converted line is: %s \nKey: %d\n\n", chipperData.getResultLine(), chipperData.getCodeKey()));
    }

    public void showResultVigenere(ChipperData chipperData) {
        System.out.print(String.format("Converted line is: %s \nCode Word: %s\n\n", chipperData.getResultLine(), chipperData.getCodeWord()));
    }

    public void underConstruction(){
        System.out.println(ErrorMessages.UNDER_CONSTRUCTION);
    }

    public void showErrorMessage(String error){
        System.out.print(error + "\n-> ");
    }

    public void showNewFileName(String fileParentDirectory, String outputFileName) {
        System.out.printf("\nOperation successful!!!\nResult created in: %s \nFile name: %s \n\n", fileParentDirectory, outputFileName);
    }

    public void showResultCaesarBrute(ChipperData chipperData) {
        System.out.println(String.format("\nPossible line: %s \nPossible key: %d \n", chipperData.getResultLine(), chipperData.getCodeKey()));
    }

    public void showGreetings() {
        System.out.println("👋 Welcome to CryptoAnalyzer App!");
    }

    public void showGoodbye() {
        System.out.println("👋 Goodbye!");
    }
}
