package com.sinnevy.minproject.web.exception;


import com.sinnevy.minproject.web.CustomError;

public class CustomException extends RuntimeException {

    private String errorCode;

    private String errorMessage;

    public CustomException() {}

    public CustomException(CustomError error) {
        super();
        this.errorCode = error.getCode();
        this.errorMessage = error.getError();
    }

    public CustomException(CustomError error, String errorMessage) {
        super(errorMessage);
        this.errorCode = error.getCode();
        this.errorMessage = errorMessage;
    }

    public CustomException(String code, String message) {
        super();
        this.errorCode = code;
        this.errorMessage = message;
    }

}
