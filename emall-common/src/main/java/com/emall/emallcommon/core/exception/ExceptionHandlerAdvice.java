package com.emall.emallcommon.core.exception;

import com.emall.emallcommon.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * @author qinlang
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result processValidationException(HttpServletRequest request, BindException ex) {
        log.error("");
        return Result.fail(CommonExceptionEnum.PARAM_ERROR, ex.getMessage());
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result processParameterException(HttpServletRequest request, MissingServletRequestParameterException ex) {
        log.error("missing servlet request parameter exception:", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("service exception:", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = {CommonException.class})
    @ResponseStatus(HttpStatus.OK)
    public Result handleBaseException(HttpServletRequest request, CommonException ex) {
        log.error(extracRequest(request), ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public Result handleException(HttpServletRequest request, Exception ex) {
        log.error("system exception", ex.getMessage());
        return Result.fail(SystemErrorType.SYSTEM_ERROR);
    }

    private String extracRequest(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String query = request.getQueryString();
        return url + "->" + query;
    }
}
