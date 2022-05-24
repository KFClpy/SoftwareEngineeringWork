package com.software.homework5.ex;

import java.io.Serial;

public class PasswordNotMatchException extends ServiceException{
    @Serial
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
