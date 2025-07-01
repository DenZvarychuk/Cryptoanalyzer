package org.cryptoanalyzer.result;

import org.cryptoanalyzer.exception.ApplicationExceptions;

public class Result {

    private ApplicationExceptions applicationExceptions;
    private String initialLine;
    private String encodedLine;
    private int key;

    public Result(String initialLine, int key){
        this.initialLine = initialLine;
        this.key = key;
        this.encodedLine = null;
    }

    public Result(String encodedLine){
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

    public ApplicationExceptions getApplicationExceptions() {
        return applicationExceptions;
    }

    public void setEncodedLine(String encodedLine) {
        this.encodedLine = encodedLine;
    }

    public void setApplicationExceptions(ApplicationExceptions applicationExceptions) {
        this.applicationExceptions = applicationExceptions;
    }

}
