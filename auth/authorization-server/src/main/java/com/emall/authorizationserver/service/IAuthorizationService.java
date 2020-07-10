package com.emall.authorizationserver.service;

import javax.servlet.http.HttpServletRequest;

public interface IAuthorizationService {

    /**
     * 资源权限校验
     * 判断资源中是否存在这个url+method
     * @param authRequest
     * @return
     */
    boolean auth(HttpServletRequest authRequest);

}
