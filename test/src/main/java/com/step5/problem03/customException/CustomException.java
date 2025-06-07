package com.step5.problem03.customException;

public class CustomException extends Exception {
    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
