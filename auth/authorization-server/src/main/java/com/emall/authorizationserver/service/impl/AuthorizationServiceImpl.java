package com.emall.authorizationserver.service.impl;

import com.emall.authorizationserver.service.IAuthorizationService;
import com.emall.authorizationserver.service.IResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 通过gateway中传入的url，method来判断是否存在权限资源（容器启动的时候加载的资源放到——》ConfigAttribute）
 */
@Service
@Slf4j
public class AuthorizationServiceImpl implements IAuthorizationService {

    public static final String NONEXISTENT_URL = "NONEXISTENT_URL";
    @Autowired
    private IResourceService resourceService;

    @Override
    public boolean auth(HttpServletRequest request, String url, String method) {
/*        log.debug("正在访问的url是:{}，method:{}", url, method);
        //获取用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取此url，method访问对应的权限资源信息
        ConfigAttribute urlConfigAttribute = resourceService.findConfigAttributesByUrl(authRequest);
        if (NONEXISTENT_URL.equals(urlConfigAttribute.getAttribute()))
            log.debug("url未在资源池中找到，拒绝访问");
        //获取此访问用户所有角色拥有的权限资源
        Set<Resource> userResources = findResourcesByUsername(authentication.getName());
        //用户拥有权限资源 与 url要求的资源进行对比
        return isMatch(urlConfigAttribute, userResources);*/
        return false;
    }
}
