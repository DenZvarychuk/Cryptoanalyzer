package org.cryptoanalyzer.result;

import org.cryptoanalyzer.repo.AlgorithmType;
import org.cryptoanalyzer.repo.ErrorMessages;
import org.cryptoanalyzer.repo.FunctionType;

public class Output {

    public void showInputLineInfo(){System.out.println("Input your line:");}
    public void showInputKeyInfo(){System.out.println("Input your key");}

    public void showResult(Result result) {
        System.out.println("Converted line is:\n" + result.getEncodedLine());
    }

    public void showInputFunctionsCodeList() {
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

    public void showInputAlgorithmCodeList(int function) {
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
}
