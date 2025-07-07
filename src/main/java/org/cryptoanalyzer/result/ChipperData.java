package org.cryptoanalyzer.result;

public class ChipperData {

    private String initialLine;
    private String resultLine;
    private int codeKey;
    private String codeWord;
    public ChipperData(){}


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
