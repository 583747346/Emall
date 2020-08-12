package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.po.RoleResourcePo;

import java.util.List;
import java.util.Set;

/**
 * 角色-资源
 */
public interface IRoleResourceService {
    boolean deleteByRoleId(Long roleId);

    boolean saveBatch(String id, Set<String> resourceIds);

    List<RoleResourcePo> queryByRoleIds(Set<Long> roleIds);
}
