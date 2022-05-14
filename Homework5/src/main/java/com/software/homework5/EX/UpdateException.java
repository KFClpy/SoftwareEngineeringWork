package com.software.homework5.EX;

public class UpdateException extends ServiceException{

    private static final long serialVersionUID = -5520693906963858574L;
    public UpdateException() {
        super();
    }
    public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
    public UpdateException(String message) {
        super(message);
    }
    public UpdateException(Throwable cause) {
        super(cause);
    }
}
