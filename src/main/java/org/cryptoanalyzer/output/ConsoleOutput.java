package org.cryptoanalyzer.output;

import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;
import org.cryptoanalyzer.result.ChipperData;

public class ConsoleOutput {

    public void showInputLineToCodeInfo(){System.out.println("Input your line:");}
    public void showInputCodeKeyInfo(){System.out.println("Input your key");}
    public void showInputCodeWordInfo() {System.out.println("Input your code word");}
    public void showInputFilePassInfo() {
        System.out.println("Your file should have propper file naming!\nCorrect name: fileNam [OPERATION] key.fileExtension\nPlease input pass to your file");
    }
    public void showAvailableFunctions() {
        StringBuilder optionList  = new StringBuilder();
        for (FunctionType function : FunctionType.values()) {
            if (function.getFunctionCode() != 101 && function.getFunctionCode() != 0) {
                optionList .append(function.getFunctionCode())
                        .append(" - ")
                        .append(function.getFunctionName())
                        .append("\n");
            }
        }
        System.out.println(String.format("Please input function code:\n%s0 - Exit", optionList ));
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
        System.out.printf("Please input algorithm code:\n%s", optionList );
    }

    public void showResultCaesar(ChipperData chipperData) {
        System.out.printf("Converted line is: %s \nKey: %d\n", chipperData.getResultLine(), chipperData.getCodeKey());
    }
    public void showResultVigenere(ChipperData chipperData) {
        System.out.printf("Converted line is: %s \nCode Word: %s", chipperData.getResultLine(), chipperData.getCodeWord());
    }

    public void underConstruction(){
        System.out.println(ErrorMessages.UNDER_CONSTRUCTION);
    }

    public void showErrorMessage(String error){
        System.out.println(error);
    }

    public void showNewFileName(String fileParentDirectory, String outputFileName) {
        System.out.printf("Operation successful\nResult created in: %s \nFile name: %s", fileParentDirectory, outputFileName);
    }

    public void showResultCaesarBrute(ChipperData chipperData) {
        System.out.println(String.format("Possible line: %s \nPossible key: %d \n", chipperData.getResultLine(), chipperData.getCodeKey()));
    }
}
