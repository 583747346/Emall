package com.emall.authenticationserver.provider;

import com.core.result.Result;
import com.emall.authenticationserver.entity.Role;
import com.emall.authenticationserver.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Set;

@FeignClient(name = "emall-manageplat", fallback = OrganizationProviderFallback.class)
public interface OrganizationProvider {

    @GetMapping(value = "/user")
    Result<User> getUserByUniqueId(String uniqueId);

    @GetMapping(value = "/role/user/{userId}")
    Result<Set<Role>> queryRolesByUserId(String userId);
}
