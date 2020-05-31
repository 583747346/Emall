package com.emall.emallmanageplat.service;

import java.util.Set;

/**
 * 角色-资源
 */
public interface IRoleResourceService {
    boolean deleteByRoleId(String roleId);

    boolean saveBatch(String id, Set<String> resourceIds);
}
