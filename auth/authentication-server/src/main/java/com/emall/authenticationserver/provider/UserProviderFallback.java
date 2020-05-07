package com.emall.authenticationserver.provider;

import com.emall.authenticationserver.entity.Role;
import com.emall.authenticationserver.entity.User;
import com.emall.emallcommon.core.result.Result;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinlang
 * 熔断器
 */

@Component
public class UserProviderFallback implements UserProvider {
    @Override
    public Result<User> getUserByUniqueId(String uniqueId) {
        return Result.success(new User());
    }

    @Override
    public Result<Set<Role>> queryRolesByUserId(String userId) {
        return Result.success(new HashSet<Role>());
    }
}
