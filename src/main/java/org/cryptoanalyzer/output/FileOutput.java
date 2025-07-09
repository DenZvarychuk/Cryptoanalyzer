package org.cryptoanalyzer.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * FileOutput class is responsible for writing results to a file.
 * It provides functionality to write a result string to a specified file path.
 */
public class FileOutput {

    /**
     * Writes the given result string to the specified output file.
     * If the file already exists, it will be truncated and overwritten.
     *
     * @param resultLine The result data to be written to the file.
     * @param outputFilePath The path to the output file.
     * @throws IOException If an I/O error occurs during file writing.
     */
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
