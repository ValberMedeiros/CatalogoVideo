package com.valbermedeiros.catalogovideo.application.exception;

public class ApplicationException extends RuntimeException{

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }
}
