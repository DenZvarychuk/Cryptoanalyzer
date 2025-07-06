package org.cryptoanalyzer.result;

import org.cryptoanalyzer.exception.ApplicationExceptions;

public class Result {

    private ApplicationExceptions applicationExceptions;

    private String initialLine;
    private String resultLine;
    private int codeKey;
    private String codeWord;

    public Result(String initialLine, int codeKey) {
        this.initialLine = initialLine;
        this.codeKey = codeKey;
    }

    public Result(){}


    public String getInitialLine() {
        return initialLine;
    }
    public String getResultLine() {
        return resultLine;
    }
    public int getCodeKey() {
        return codeKey;
    }
    public String getCodeWord() {return codeWord;}

    public void setResultLine(String resultLine) {
        this.resultLine = resultLine;
    }
    public void setInitialLine(String initialLine) {
        this.initialLine = initialLine;
    }
    public void setCodeKey(int codeKey) {
        this.codeKey = codeKey;
    }
    public void setCodeWord(String codeWord) {this.codeWord = codeWord;}


}
