package com.software.homework5.ex;

import java.io.Serial;

public class UsernotfoundException extends ServiceException{

    @Serial
    private static final long serialVersionUID = -6759019154986630575L;
    public UsernotfoundException() {
        super();
    }
    public UsernotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public UsernotfoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public UsernotfoundException(String message) {
        super(message);
    }
    public UsernotfoundException(Throwable cause) {
        super(cause);
    }
}

