package org.cryptoanalyzer.result;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.output.ConsoleOutput;
import org.cryptoanalyzer.repo.AlgorithmType;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.cryptoanalyzer.repo.ErrorMessages.*;

/**
 * This class encapsulates the data of a file, including its path, name, algorithm, key,
 * and content. It is used to parse and handle files related to encryption and decryption operations.
 */
public class FileData {

    private Path filePath;
    private Path outputFilePath;
    private String outputFileName;
    private String fileFullName;
    private String fileName;
    private String fileParentDirectory;
    private String fileExtension;
    private String fileKey;
    private String fileAlgorithm;
    private String fileContent;

    private ConsoleOutput consoleOutput = new ConsoleOutput();

    /**
     * Parses the given file path to extract the file's components such as name, algorithm, key, and extension.
     *
     * @param path the file path to be parsed
     * @throws ApplicationExceptions if the file name doesn't match the expected pattern
     */
    public void parseFileName(Path path) throws ApplicationExceptions {
        this.filePath = path;
        this.fileFullName = path.getFileName().toString();
        this.fileParentDirectory = path.getParent().toString();

        Pattern pattern = Pattern.compile("^(.*?)\\s*(?:\\[(.*?)\\])?\\s+([^\\s.]+)\\.(\\w+)$");
        Matcher matcher = pattern.matcher(fileFullName);

        try {
            if (matcher.matches()) {
                this.fileName = matcher.group(1);
                this.fileAlgorithm = matcher.group(2);
                this.fileKey = matcher.group(3);
                this.fileExtension = "." + matcher.group(4);
            } else {
                throw new ApplicationExceptions(INCORRECT_FILE_NAME);
            }
        } catch (ApplicationExceptions e) {
            consoleOutput.showErrorMessage(e.getMessage());
            throw e;
            //TODO throw exception correctly
        }
    }

    /**
     * Parses the output file name and path based on the algorithm type for the operation.
     *
     * @param algorithmType the algorithm type used for encryption/decryption
     */
    public void parseOutputFilePathName(AlgorithmType algorithmType) {
        String label;
        switch (algorithmType) {
            case CAESAR_CIPHER_ENCODE, VIGENERE_CIPHER_ENCODE -> label = "[ENCRYPTED]";
            case CAESAR_CIPHER_DECODE, VIGENERE_CIPHER_DECODE -> label = "[DECRYPTED]";
            default -> label = null;
        }
        outputFileName = String.format("%s %s%s", fileName, label, fileExtension).trim();
        outputFilePath = Path.of(fileParentDirectory, outputFileName);
    }

    /**
     * Parses the output file name and path based on the algorithm name for the operation.
     *
     * @param algorithm the algorithm name (e.g., "ENCRYPT", "DECRYPT")
     */
    public void parseOutputFilePathName(String algorithm) {
        String label;
        switch (algorithm) {
            case "ENCRYPT" -> label = "[ENCRYPTED]";
            case "DECRYPT", "BRUTE_FORCE" -> label = "[DECRYPTED]";
            default -> label = null;
        }
        outputFileName = String.format("%s %s%s", fileName, label, fileExtension).trim();
        outputFilePath = Path.of(fileParentDirectory, outputFileName);
    }

    public String getFileFullName() {
        return fileFullName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileParentDirectory() {
        return fileParentDirectory;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileKey() {
        return fileKey;
    }

    public String getFileAlgorithm() {
        return fileAlgorithm;
    }

    public Path getFilePath() {
        return filePath;
    }

    public String getFileContent() {
        return fileContent;
    }

    public Path getOutputFilePath() {
        return outputFilePath;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

}
