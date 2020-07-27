package com.emall.authorizationserver.service.impl;

import com.emall.authorizationserver.entity.Resource;
import com.emall.authorizationserver.provider.ResourceProvider;
import com.emall.authorizationserver.service.IResourceService;
import com.emall.authorizationserver.tools.NewMvcRequestMatcher;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    private static final Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes = new HashMap<>();

    @Override
    public ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest) {
        return resourceConfigAttributes.keySet().stream()
                .filter(requestMatcher -> requestMatcher.matches(authRequest))
                .map(requestMatcher -> resourceConfigAttributes.get(requestMatcher))
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
    public synchronized void loadResource() {
        Set<Resource> resources = resourceProvider.getResources().getData();
        Map<MvcRequestMatcher, SecurityConfig> resourceConfigValues = resources.stream()
                .collect(Collectors.toMap(
                        resource -> this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()),
                        resource -> new SecurityConfig(resource.getCode())
                ));
        resourceConfigAttributes.putAll(resourceConfigValues);
        log.debug("初始化resourceConfigAttributes（资源信息）：" + this.resourceConfigAttributes);
    }

    /**
     * 消费rabbitmq key为resource-queue的队列消息
     *
     * @param resource
     */
    @Override
    public synchronized void saveResource(ResourcePo resource) {
        //将消息插入到权限集合
        resourceConfigAttributes.put(
                this.newMvcRequestMatcher(resource.getUrl(), resource.getMethod()),
                new SecurityConfig(resource.getCode())
        );
        log.info("*****************************************************************");
        log.info("队列中消息体：{}", resource);
        log.info("权限集合中总数：{}", resourceConfigAttributes.size());
        log.info("*****************************************************************");
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
