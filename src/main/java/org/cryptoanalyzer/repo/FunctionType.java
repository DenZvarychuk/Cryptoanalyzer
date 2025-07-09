package org.cryptoanalyzer.repo;

public enum FunctionType {
    ENCODE(1, "Encode"),
    DECODE(2, "Decode"),
    BRUT_FORCE(3, "Brute Force"),
    AUTO_MODE(4, "AutoMode (Should be correct file naming)"),
    MANUAL_TESTING(5, "Manual mode"),
    EXIT(0, "");


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
