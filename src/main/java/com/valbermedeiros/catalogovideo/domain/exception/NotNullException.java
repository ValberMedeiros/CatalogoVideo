package com.valbermedeiros.catalogovideo.domain.exception;

public class NotNullException extends DomainException{

    public NotNullException() {
        super();
    }

    public NotNullException(String message) {
        super(message);
    }
}
