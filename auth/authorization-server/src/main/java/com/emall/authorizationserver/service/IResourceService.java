package com.emall.authorizationserver.service;

import com.emall.authorizationserver.entity.Resource;
import com.emall.authorizationserver.event.ResourceMessage;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface IResourceService {

    /**
     * 根据url匹配资源信息
     * @param authRequest
     * @return
     */
    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

    /**
     * 通过用户名查询资源
     * @param name
     * @return
     */
    Set<Resource> queryByUsername(String name);

    /**
     * 服务启动加载资源
     */
    void loadResource();

    /**
     * rabbitmq消费消息，加载资源
     */
    void saveResource(ResourceMessage resourceMessage);

}
