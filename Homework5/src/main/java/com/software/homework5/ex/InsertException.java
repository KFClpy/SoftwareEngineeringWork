package com.software.homework5.ex;

import java.io.Serial;

public class InsertException extends ServiceException{
    @Serial
    private static final long serialVersionUID = -3616160497168012088L;

    public InsertException() {
        super();
    }

    public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

}
