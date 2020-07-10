package com.emall.authorizationserver.config;

import com.emall.authorizationserver.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author
 * 在服务启动的时候加载所有的资源信息
 */
@Component
public class LoadResourceDefinition {

    @Autowired
    private IResourceService resourceService;

    @Bean
    public Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes() {
        return resourceService.loadResource();
    }
}
