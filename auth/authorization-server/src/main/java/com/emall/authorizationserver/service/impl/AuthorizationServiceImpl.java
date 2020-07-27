package com.emall.authorizationserver.service.impl;

import com.emall.authorizationserver.entity.Resource;
import com.emall.authorizationserver.service.IAuthorizationService;
import com.emall.authorizationserver.service.IResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

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
    public boolean auth(HttpServletRequest authRequest) {
        log.debug("*******************************************************************");
        log.debug("正在访问的url:{}", authRequest.getRequestURL());
        log.debug("正在访问的method:{}", authRequest.getMethod());
        log.debug("*******************************************************************");
        //获取用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取此url，method访问对应的权限资源信息
        ConfigAttribute urlConfigAttribute = resourceService.findConfigAttributesByUrl(authRequest);
        if (urlConfigAttribute ==null || NONEXISTENT_URL.equals(urlConfigAttribute.getAttribute())){
            log.debug("url未在资源池中找到，拒绝访问");
            return false;
        }

        //获取此访问用户所有角色拥有的权限资源
        Set<Resource> userResources = findResourcesByUsername(authentication.getName());
        //用户拥有权限资源 与 url要求的资源进行对比
        return isMatch(urlConfigAttribute, userResources);
    }

    /**
     * url对应资源与用户拥有资源进行匹配
     *
     * @param urlConfigAttribute
     * @param userResources
     * @return
     */
    public boolean isMatch(ConfigAttribute urlConfigAttribute, Set<Resource> userResources) {
        return userResources.stream().anyMatch(resource -> resource.getCode().equals(urlConfigAttribute.getAttribute()));
    }

    /**
     * 根据用户所被授予的角色，查询到用户所拥有的资源
     *
     * @param name
     * @return
     */
    private Set<Resource> findResourcesByUsername(String name) {
        //用户被授予的角色资源
        Set<Resource> resources = resourceService.queryByUsername(name);
        if (log.isDebugEnabled()) {
            log.debug("用户被授予角色的资源数量是:{}, 资源集合信息为:{}", resources.size(), resources);
        }
        return resources;
    }
}
