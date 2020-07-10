package com.emall.authorizationserver.service.impl;

import com.emall.authorizationserver.entity.Resource;
import com.emall.authorizationserver.provider.ResourceProvider;
import com.emall.authorizationserver.service.IResourceService;
import com.emall.authorizationserver.tools.NewMvcRequestMatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private HandlerMappingIntrospector mvcHandlerMappingIntrospector;
    @Autowired
    private ResourceProvider resourceProvider;

    /**
     * 系统中所有权限集合
     */
    private Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes;

    @Override
    public ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest) {
        return this.resourceConfigAttributes.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(authRequest))
                .map(requestMatcher -> this.resourceConfigAttributes.get(requestMatcher))
                .peek(urlConfigAttribute -> log.debug("url在资源池中配置：", urlConfigAttribute.getAttribute()))
                .findFirst()
                .orElse(new SecurityConfig("NONEXISTENT_URL"));
    }

    @Override
    public Set<Resource> queryByUsername(String name) {
        return resourceProvider.getResources(name).getData();
    }

    /**
     * 加载资源信息
     *
     * @return
     */
    @Override
    public Map<RequestMatcher, ConfigAttribute> loadResource() {
        Set<Resource> resources = resourceProvider.getResources().getData();
        this.resourceConfigAttributes = resources.stream()
                .collect(Collectors.toMap(
                        resource -> this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()),
                        resource -> new SecurityConfig(resource.getCode())
                ));
        log.debug("初始化resourceConfigAttributes（资源信息）：" + this.resourceConfigAttributes);
        return this.resourceConfigAttributes;
    }

    /**
     * 创建RequestMatcher
     * 主要是用于匹配http请求的url
     *
     * @param url
     * @param method
     * @return
     */
    private MvcRequestMatcher newMvcRequestMatcher(String url, String method) {
        return new NewMvcRequestMatcher(mvcHandlerMappingIntrospector, url, method);
    }

}
