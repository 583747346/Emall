package com.emall.authenticationserver.exception;

import feign.FeignException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.DefaultThrowableAnalyzer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.util.ThrowableAnalyzer;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 观看源码知道，当在认证或授权过程中抛出异常，
 * 抛出的异常都会经过DefaultWebResponseExceptionTranslator默认实现类进行处理，然后返回给客户端
 * 这里自定义实现WebResponseExceptionTranslator转换默认处理逻辑，在endpoints里面让实现类生效即可
 * @author qinlang
 *
 */
@Configuration
public class MyWebResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception> {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e){
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity.status(oAuth2Exception.getHttpErrorCode())
                .body(new MyOauthException(oAuth2Exception));          //这里body配置成自己自定义的异常类
    }

    @Bean
    public WebResponseExceptionTranslator<OAuth2Exception> myWebResponseTranslator() {
        return new MyWebResponseExceptionTranslator();
    }
}
