package de.herrtechniker.exception;

public class DefaultLanguageNotExistsException extends RuntimeException {

    public DefaultLanguageNotExistsException() {super("The default language was not set");}

    public DefaultLanguageNotExistsException(String errorMessage) {super(errorMessage);}
}
