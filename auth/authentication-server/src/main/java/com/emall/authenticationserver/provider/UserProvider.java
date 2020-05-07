package com.emall.authenticationserver.provider;

import com.emall.authenticationserver.entity.Role;
import com.emall.authenticationserver.entity.User;
import com.emall.emallcommon.core.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "emall-manageplat", fallback = UserProviderFallback.class)
public interface UserProvider {

    @GetMapping(value = "/user")
    Result<User> getUserByUniqueId(@RequestParam("uniqueId") String uniqueId);

    @GetMapping(value = "/role/user/{userId}")
    Result<Set<Role>> queryRolesByUserId(@RequestParam("userId") String userId);
}
