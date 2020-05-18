package com.emall.emallcommon.core.exception;

/**
 * @author qinlang
 * @since jdk1.8
 */
public class CommonException extends RuntimeException {

    protected Integer code = 5000;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CommonException(IExceptionInfo exceptionInfo) {
        this(exceptionInfo.getCode(), exceptionInfo.getMessage());
    }

    public CommonException(IExceptionInfo exceptionInfo, String message) {
        super(message);
        this.code = exceptionInfo.getCode();
    }

    public CommonException(IExceptionInfo exceptionInfo, Throwable cause) {
        super(exceptionInfo.getMessage(), cause);
        this.code = exceptionInfo.getCode();
    }

    public CommonException(IExceptionInfo exceptionInfo, String message, Throwable cause) {
        super(message, cause);
        this.code = exceptionInfo.getCode();
    }

    @Override
    public String toString() {
        return "CommonException{" + "message='" + this.getMessage() + '\'';
    }
}
