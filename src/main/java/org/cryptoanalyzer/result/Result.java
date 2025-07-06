package org.cryptoanalyzer.result;

public class Result {

    private String initialLine;
    private String resultLine;
    private int codeKey;
    private String codeWord;
    private String filePath;

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
    public String getFilePath() {return filePath;}

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
    public void setPath(String filePath) {
        this.filePath = filePath;
    }

}
