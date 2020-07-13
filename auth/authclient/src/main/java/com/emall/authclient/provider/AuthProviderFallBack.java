package com.emall.authclient.provider;


import com.emall.emallcore.exception.SystemErrorType;
import com.emall.emallcore.result.Result;
import org.springframework.stereotype.Component;

/**
 * 注入到spring容器
 *
 * 降级统一返回无权限
 */
@Component
public class AuthProviderFallBack implements AuthProvider{
    @Override
    public Result auth(String authentication, String url, String method) {
        return Result.fail(SystemErrorType.UNAUTHORIZATION);
    }
}
