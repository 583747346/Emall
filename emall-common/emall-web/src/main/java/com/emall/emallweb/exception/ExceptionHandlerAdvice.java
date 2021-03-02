package com.emall.emallweb.exception;

import com.emall.emallcore.exception.BaseException;
import com.emall.emallcore.exception.OssOperationException;
import com.emall.emallcore.exception.SystemErrorType;
import com.emall.emallcore.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

/**
 * @author qinlang
 * 全局异常
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 上传文件的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MultipartException.class})
    public Result uploadFileLimitException(MultipartException ex) {
        log.error("upload file size limit:{}", ex.getMessage());
        return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
    }

    /**
     * 请求参数遗失异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("missing servlet request parameter exception:", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    /**
     * 上传|删除OSS文件异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {OssOperationException.class})
    public Result missingServletRequestParameterException(OssOperationException ex) {
        return Result.fail(SystemErrorType.OSS_UPLOAD_DELETE_FAIL, ex.getMessage());
    }

    /**
     * 方法参数无效异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("service method args:", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * key重复异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public Result duplicateKeyException(DuplicateKeyException ex) {
        log.error("primary key duplication exception:", ex.getMessage());
        return Result.fail(SystemErrorType.DUPLICATE_PRIMARY_KEY);
    }

    @ExceptionHandler(value = {BaseException.class})
    public Result handleBaseException(BaseException ex) {
        log.error("base exception:" + ex.getMessage());
        return Result.fail(ex.getErrorType());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception() {
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable() {
        return Result.fail();
    }

}
