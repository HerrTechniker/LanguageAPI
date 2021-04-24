package de.herrtechniker.exception;

public class LanguageAlreadyExistsException extends RuntimeException {

    public LanguageAlreadyExistsException() {super("The specified language already exists");}

    public LanguageAlreadyExistsException(String errorMessage) {super(errorMessage);}
}
