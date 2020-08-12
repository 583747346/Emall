package com.emall.authenticationserver.service;

import com.emall.authenticationserver.entity.Role;

import java.util.Set;

public interface IRoleService {

    Set<Role> queryUserRolesByUserId(Long userId);

}
