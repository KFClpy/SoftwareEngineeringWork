package com.software.homework5.ex;

import java.io.Serial;

public class UsernameDuplicateException extends ServiceException{
    @Serial
    private static final long serialVersionUID = -5135645126761115446L;

    public UsernameDuplicateException() {
        super();
    }
    public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public UsernameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsernameDuplicateException(String message) {
        super(message);
    }
    public UsernameDuplicateException(Throwable cause) {
        super(cause);
    }
}

