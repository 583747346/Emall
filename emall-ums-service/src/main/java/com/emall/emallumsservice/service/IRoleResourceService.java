package com.emall.emallumsservice.service;


import com.emall.emallumsentity.entity.po.RoleResourcePo;

import java.util.List;
import java.util.Set;

/**
 * 角色-资源
 */
public interface IRoleResourceService {

    boolean deleteByRoleId(Long roleId);

    /**
     * 批量插入资源  用于导入
     * @param id
     * @param resourceIds
     * @return
     */
    boolean saveAll(String id, Set<String> resourceIds);

    /**
     * 根据角色id查询资源信息
     * @param roleIds
     * @return
     */
    List<RoleResourcePo> queryByRoleIds(Set<Long> roleIds);

    /**
     * 根据角色id，批量保存角色资源信息
     * @param roleResourcePos
     * @return
     */
    boolean saveRoleResourceAll(List<RoleResourcePo> roleResourcePos);

    List<RoleResourcePo> getResourceByRoleId(Long roleId);
}
