package org.cryptoanalyzer.repo;

public enum FunctionType {
    ENCODE(1, "Шифрування"),
    DECODE(2, "Дешифрування"),
    BRUT_FORCE(3, "Брутфорс"),
    AUTO_MODE(4, "Автоматичний режим (потрібний правильний неймінг файлу)"),
    MANUAL_TESTING(101, "");

    private final int functionCode;
    private final String functionName;

    FunctionType(int functionCode, String functionName){
        this.functionCode = functionCode;
        this.functionName = functionName;
    }

    public int getFunctionCode(){
        return functionCode;
    }

    public String getFunctionName(){
        return functionName;
    }

}
