package com.emall.gatewayweb.service.impl;

import com.emall.gatewayweb.service.IAuthService;
import com.emall.gatewayweb.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {

    /**
     * 由authentication-client模块提供签权的feign客户端
     */
    @Autowired
    private IAuthService authService;

    @Override
    public boolean permission(String authentication, String url, String method) {
        return authService.hasPermission(authentication, url, method);
    }
}
