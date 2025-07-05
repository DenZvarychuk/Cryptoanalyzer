package org.cryptoanalyzer.result;

import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;

public class Output {

    public void showInputLineToCodeInfo(){System.out.println("Input your line:");}
    public void showInputCodeKeyInfo(){System.out.println("Input your key");}

    public void showInputCodeWordInfo() {System.out.println("Input your code word");}

    public void showResultCaesar(Result result) {
        System.out.printf("Converted line is: %s \nKey: %d", result.getResultLine(), result.getCodeKey());
    }
    public void showResultVigenere(Result result) {
        System.out.printf("Converted line is: %s \nCode Word: %s", result.getResultLine(), result.getCodeWord());
    }

    public void showAvailableFunctions() {
        StringBuilder optionList  = new StringBuilder();
        for (FunctionType function : FunctionType.values()) {
            if (function.getFunctionCode() != 101) {
                optionList .append(function.getFunctionCode())
                        .append(" - ")
                        .append(function.getFunctionName())
                        .append("\n");
            }
        }
        System.out.printf("Please input function code:\n%s", optionList );
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

    public void underConstruction(){
        System.out.println(ErrorMessages.UNDER_CONSTRUCTION);
    }

    public void showErrorMessage(String error){
        System.out.println(error);
    }
}
