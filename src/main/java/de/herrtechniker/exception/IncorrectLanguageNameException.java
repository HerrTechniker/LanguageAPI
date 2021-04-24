package de.herrtechniker.exception;

public class IncorrectLanguageNameException extends RuntimeException {

    public IncorrectLanguageNameException() {super("The specified language is not supported");}

    public IncorrectLanguageNameException(String errorMessage) {super(errorMessage);}
}
