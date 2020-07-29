package com.emall.emallcore.exception;

public class ImgUploadException extends  Exception{

    public ImgUploadException() {
        super();
    }

    public ImgUploadException(String message) {
        super(message);
    }

    public ImgUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImgUploadException(Throwable cause) {
        super(cause);
    }

    protected ImgUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
