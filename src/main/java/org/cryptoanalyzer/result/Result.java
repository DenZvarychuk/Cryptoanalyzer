package org.cryptoanalyzer.result;

public class Result {

    private String initialLine;

    private String encodedLine;
    private int key;

    public Result(String initialLine, int key){
        this.initialLine = initialLine;
        this.key = key;
        this.encodedLine = null;
    }

    public Result(String encodedLine){
        this.initialLine = getInitialLine();
        this.key = getKey();
        this.encodedLine = encodedLine;
    }

    public String getInitialLine() {
        return initialLine;
    }

    public String getEncodedLine() {
        return encodedLine;
    }

    public int getKey() {
        return key;
    }

    public void setEncodedLine(String encodedLine) {
        this.encodedLine = encodedLine;
    }

}
