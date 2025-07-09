package org.cryptoanalyzer.repo;

/**
 * This class contains predefined error messages that are used throughout the application for consistent error handling.
 */
public class ErrorMessages {

    public final static String EMPTY_LINE = "ERROR: Invalid input\nLine cannot be empty.\nPlease try again.";
    public final static String INVALID_KEY = "ERROR: Invalid input\nKey should be a valid number\nPlease try again.";
    public final static String INCORRECT_SYMBOL = "ERROR: Invalid input\nCode Word must contain only alphabet letters";
    public final static String INVALID_FUNCTION_CODE = "ERROR: Invalid Function Code\nPlease enter a valid Function Code";
    public final static String INVALID_ALGORITHM_CODE = "ERROR: Invalid Algorithm Code\nPlease enter a valid Function Code";
    public final static String INVALID_PATH = "ERROR: Invalid File Path\nPlease start with something like C:/";
    public final static String FILE_DOES_NOT_EXIST = "ERROR: File does not exist. Please enter a valid path";
    public final static String INCORRECT_FILE_NAME = "ERROR: Filename format is invalid";
    public final static String EMPTY_FILE = "ERROR: File is empty";
    public final static String INCORRECT_ALGORITHM_FILENAME = "ERROR: Incorrect chipper algorithm in file name";
    public final static String INCORRECT_FILE_KEY = "ERROR: File key must contain only alphabet letters OR digits";
    public final static String UNKNOWN_FUNCTION = "Error: Unknown function code: ";
    public final static String UNKNOWN_ALGORITHM = "Error: Unknown algorithm code: ";

    public final static String UNDER_CONSTRUCTION = "This function is unavailable and still under construction";

}
