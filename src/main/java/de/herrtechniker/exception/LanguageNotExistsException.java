package de.herrtechniker.exception;

public class LanguageNotExistsException extends RuntimeException {

    public LanguageNotExistsException() {super("The specified language doesn´t exists");}

    public LanguageNotExistsException(String errorMessage) {super(errorMessage);}
}
