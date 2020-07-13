package com.emall.authclient.service;

import com.emall.emallcore.result.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface IAuthService {

    /**
     * 忽略的url
     * @param url
     * @return
     */
    boolean ignoreAuthentication(String url);

    /**
     * 校验传入的url是否有访问权限
     * @param authentication
     * @param url
     * @param method
     * @return
     */
    boolean hasPermission(String authentication, String url, String method);

    /**
     * 调用签权服务，判断用户是否有权限
     *
     * @param authentication
     * @param url
     * @param method
     * @return Result
     */
    Result authenticate(String authentication, String url, String method);


    /**
     * 查看签权服务器返回结果，有权限返回true
     *
     * @param authResult
     * @return
     */
    boolean hasPermission(Result authResult);


    /**
     * 是否无效authentication
     *
     * @param authentication
     * @return
     */
    boolean invalidJwtAccessToken(String authentication);


    /**
     * 从认证信息中提取jwt token 对象
     *
     * @param jwtToken toke信息 header.payload.signature
     * @return Jws对象
     */
    Jws<Claims> getJwt(String jwtToken);
}
