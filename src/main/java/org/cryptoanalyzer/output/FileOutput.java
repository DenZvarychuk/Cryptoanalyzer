package org.cryptoanalyzer.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOutput {

    private final ConsoleOutput consoleOutput = new ConsoleOutput();

    public void createOutputFile(Path outputFilePath) throws IOException {
        if(!Files.exists(outputFilePath)) Files.createFile(outputFilePath);
    }

    public void writeResult(String resultLine, Path outputFilePath) throws IOException  {
        try(BufferedWriter writer = Files.newBufferedWriter(outputFilePath, StandardCharsets.UTF_8)){

        }
    }
}
