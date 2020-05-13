package com.emall.authorizationserver.provider;

import com.emall.authorizationserver.entity.Resource;
import com.emall.emallcommon.core.result.Result;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class ResourceProviderFallback implements ResourceProvider{
    @Override
    public Result<Set<Resource>> resources(String name) {
        return Result.success(new HashSet<Resource>());
    }
}
