package com.emall.authclient.service;

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
}
