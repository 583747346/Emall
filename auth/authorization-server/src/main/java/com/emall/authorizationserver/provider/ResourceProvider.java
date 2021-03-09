package com.emall.authorizationserver.provider;

import com.emall.authorizationserver.entity.Resource;
import com.emall.emallcore.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "emall-ums-service", fallback = ResourceProviderFallback.class)
@Component
public interface ResourceProvider {

    @GetMapping(value = "/resource/user/{username}")
    Result<Set<Resource>> getResources(@PathVariable("username") String username);  //这里一定要加PathVariable

    @GetMapping(value = "/resource/all")
    Result<Set<Resource>>  getResources();
}
