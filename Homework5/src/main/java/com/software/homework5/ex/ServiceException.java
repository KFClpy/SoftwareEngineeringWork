package com.software.homework5.ex;


import java.io.Serial;

public class ServiceException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -2458056813173628011L;

    public ServiceException() {
        super();
    }
    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
