package org.cryptoanalyzer.repo;

public enum FunctionType {
    ENCODE(1, "Шифрування"),
    DECODE(2, "Дешифрування"),
    BRUT_FORCE(3, "Брутфорс"),
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
