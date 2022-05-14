package com.software.homework5.EX;

public class PasswordNotMatchException extends ServiceException{
    private static final long serialVersionUID = 121611732685756651L;
    public PasswordNotMatchException() {
        super();
    }
    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }
    public PasswordNotMatchException(String message) {
        super(message);
    }
    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }
}
