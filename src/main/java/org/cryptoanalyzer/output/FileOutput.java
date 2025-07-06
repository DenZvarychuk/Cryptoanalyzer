package org.cryptoanalyzer.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileOutput {

    public void writeResult(String resultLine, Path outputFilePath) throws IOException  {
        try(BufferedWriter writer = Files.newBufferedWriter(
                outputFilePath,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)){
            writer.write(resultLine);
        }
    }
}
