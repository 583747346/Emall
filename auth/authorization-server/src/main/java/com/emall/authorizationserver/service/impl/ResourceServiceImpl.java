package com.emall.authorizationserver.service.impl;

import com.emall.authorizationserver.entity.Resource;
import com.emall.authorizationserver.provider.ResourceProvider;
import com.emall.authorizationserver.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceProvider resourceProvider;

    @Override
    public ConfigAttribute findConfigAttributesByUrl(HttpServletRequest request, String url, String method) {
        return null;
    }

    @Override
    public Set<Resource> queryByUsername(String name) {
        return resourceProvider.resources(name).getData();
    }
}
