package com.emall.authorizationserver.provider;

import com.emall.authorizationserver.entity.Resource;
import com.emall.emallcommon.core.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "emall-manageplat", fallback = ResourceProviderFallback.class)
public interface ResourceProvider {

    @GetMapping(value = "/resource")
    Result<Set<Resource>> resources(@RequestParam("username") String username);  //这里一定要加RequestParam
}
