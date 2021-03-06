package com.emall.emallcore.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private String code;  //异常状态码

    private String message;  //异常信息

    private String method;   //发生的方法，位置等

    private String descinfo;   //描述

    public MyException(String code, String message, String method, String descinfo) {
        this.code = code;
        this.message = message;
        this.method = method;
        this.descinfo = descinfo;
    }
}
