package com.emall.authenticationserver.service.impl;

import com.emall.authenticationserver.entity.Role;
import com.emall.authenticationserver.provider.UserProvider;
import com.emall.authenticationserver.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private UserProvider userProvider;

    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return userProvider.queryRolesByUserId(userId).getData();
    }

}
