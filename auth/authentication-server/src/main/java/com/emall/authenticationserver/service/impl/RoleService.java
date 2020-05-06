package com.emall.authenticationserver.service.impl;

import com.emall.authenticationserver.entity.Role;
import com.emall.authenticationserver.provider.OrganizationProvider;
import com.emall.authenticationserver.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public Set<Role> queryUserRolesByUserId(String userId) {
        return organizationProvider.queryRolesByUserId(userId).getData();
    }

}
