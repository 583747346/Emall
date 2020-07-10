package com.emall.authorizationserver.provider;

import com.emall.authorizationserver.entity.Resource;
import com.emall.emallcommon.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class ResourceProviderFallback implements ResourceProvider{
    @Override
    public Result<Set<Resource>> getResources(String name) {
        log.error("资源服务器查询用户资源权限异常，为加载到资源");
        return Result.success(new HashSet<Resource>());
    }

    @Override
    public Result<Set<Resource>> getResources() {
        log.error("资源服务器启动时加载资源异常！未加载到资源");
        return Result.success(new HashSet<Resource>());
    }
}
