package com.emall.emallcommon.core.exception;

/**
 * @author qinlang
 * @since jdk1.8
 */
public enum CommonExceptionEnum implements IExceptionInfo {

    SUCCESS(200, "SUCCESS"),
    SYS_ERROR(9000, "系统错误"),
    PARAM_ERROR(4001, "参数错误"),
    DATA_NOT_FOUND(4004, "未找到数据"),
    SERVICE_ERROR(5000, "服务器异常"),
    REPEAT_REQUEST(5001, "重复的请求"),

    ETL_RUNNING_ERROR(5005, "数据更新中，请稍后..."),
    ;

    private int code;
    private String message;

    private CommonExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}