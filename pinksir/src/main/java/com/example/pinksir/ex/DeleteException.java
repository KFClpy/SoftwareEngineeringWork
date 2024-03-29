package com.example.pinksir.ex;

public class DeleteException extends ServiceException{
    private static final long serialVersionUID = -3616160497357012088L;

    public DeleteException() {
        super();
    }

    public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public  DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }
}
