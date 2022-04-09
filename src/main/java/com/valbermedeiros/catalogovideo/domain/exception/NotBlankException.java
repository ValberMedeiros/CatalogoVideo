package com.valbermedeiros.catalogovideo.domain.exception;

public class NotBlankException extends DomainException{

    public NotBlankException() {
        super();
    }

    public NotBlankException(String message) {
        super(message);
    }
}
