package com.emall.authorizationserver.service;

import com.emall.authorizationserver.entity.Resource;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface IResourceService {

    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest request, String url, String method);

    Set<Resource> queryByUsername(String name);
}
