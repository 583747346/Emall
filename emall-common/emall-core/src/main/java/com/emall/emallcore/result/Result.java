package com.emall.emallcore.result;

import com.emall.emallcore.exception.ErrorType;
import com.emall.emallcore.exception.SystemErrorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

@Data
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "200";
    public static final String SUCCESSFUL_MESG = "处理成功";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = ZonedDateTime
                .now ()
                .toInstant ();
    }

    //主要用于认证授权异常返回增强
    public Result(ErrorType errorType) {
        this.code = errorType.getCode ();
        this.mesg = errorType.getMesg ();
        this.time = ZonedDateTime
                .now ()
                .toInstant ();
    }

    //主要用于认证授权异常返回增强
    public Result(ErrorType errorType, T data) {
        this (errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime
                .now ()
                .toInstant ();
    }

    public static Result success(Object data) {
        return new Result<> (SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    public static Result fail(ErrorType errorType, Object data) {
        return new Result<> (errorType, data);
    }

    public static Result fail(ErrorType errorType) {
        return Result.fail (errorType, null);
    }

    public static Result fail() {
        return new Result (SystemErrorType.SYSTEM_ERROR);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }
}
