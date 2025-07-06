package org.cryptoanalyzer.result;

import org.cryptoanalyzer.exception.ApplicationExceptions;
import org.cryptoanalyzer.output.ConsoleOutput;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.cryptoanalyzer.repo.ErrorMessages.*;

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
    private boolean isEmpty;

    private ConsoleOutput consoleOutput = new ConsoleOutput();

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
        } catch (ApplicationExceptions e){
            consoleOutput.showErrorMessage(e.getMessage());
        }

    }

    public void parseOutputFilePathName(int algorithmTypeCode) {
        String label;
        if (algorithmTypeCode == 1) label = "[ENCRYPTED]";
        else if (algorithmTypeCode == 2) label = "[DECRYPTED]";
        else label = "[RESULT]";

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
    public Path getFilePath(){
        return filePath;}
    public String getFileContent() {
        return fileContent;
    }
    public Path getOutputFilePath(){
        return outputFilePath;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

}
