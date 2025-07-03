package org.cryptoanalyzer.result;

import org.cryptoanalyzer.exception.ApplicationExceptions;

public class Result {

    private ApplicationExceptions applicationExceptions;

    private String initialLine;
    private String encodedLine;
    private int key;

    public Result(String encodedLine){
        this.encodedLine = encodedLine;
    }

    public Result(String initialLine, int key) {
        this.initialLine = initialLine;
        this.key = key;
    }

    //TODO get this works somehow
    public ApplicationExceptions getApplicationExceptions() {
        return applicationExceptions;
    }
    public void setApplicationExceptions(ApplicationExceptions applicationExceptions) {
        this.applicationExceptions = applicationExceptions;
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
    public void setInitialLine(String initialLine) {
        this.initialLine = initialLine;
    }
    public void setKey(int key) {
        this.key = key;
    }






}
