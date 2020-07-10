package com.emall.authorizationserver.service;

import com.emall.authorizationserver.entity.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public interface IResourceService {

    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

    Set<Resource> queryByUsername(String name);

    Map<RequestMatcher, ConfigAttribute> loadResource();
}
