package com.emall.emallcommon.web.exception;

import com.emall.emallcommon.core.exception.BaseException;
import com.emall.emallcommon.core.exception.MyException;
import com.emall.emallcommon.core.exception.SystemErrorType;
import com.emall.emallcommon.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinlang
 * 全局异常
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 上传文件的异常
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
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error ("missing servlet request parameter exception:", ex.getMessage ());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    /**
     * 方法参数无效异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error ("service method args:", ex.getMessage ());
        return Result.fail (SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult ().getFieldError ().getDefaultMessage ());
    }

    /**
     * key重复异常
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
        log.error ("base exception:"+ ex.getMessage ());
        return Result.fail (ex.getErrorType ());
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

    @ExceptionHandler(value = MyException.class)
    public Map<String,Object> myExceptionHandler(MyException myex){
        Map<String,Object> map  = new HashMap<String,Object> ();
        map.put("code",myex.getCode());
        map.put("message",myex.getMessage());
        map.put("method",myex.getMethod());
        map.put("descinfo",myex.getDescinfo());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }
}
