package com.emall.authenticationserver.exception;

import com.emall.emallcore.result.Result;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@EqualsAndHashCode(callSuper = true)
//指定json序列化的方式
@JsonSerialize(using = MyOauthExceptionSerializer.class)
@Getter
public class MyOauthException extends OAuth2Exception{

    private final Result result;

    public MyOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = Result.fail(AuthErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()), oAuth2Exception);
    }
}
