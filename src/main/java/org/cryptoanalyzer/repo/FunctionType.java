package org.cryptoanalyzer.repo;

public enum FunctionType {
    ENCODE(1),
    DECODE(2),
    BRUT_FORCE(3),
    MANUAL_TESTING(101);

    private int functionCode;

    FunctionType(int functionCode){
        this.functionCode = functionCode;
    }

    public int getFunctionCode(){
        return functionCode;
    }


}
