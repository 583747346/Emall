package com.emall.emallumsservice.service;


import com.emall.emallumsentity.entity.po.RoleMenuPo;

import java.util.List;

public interface IRoleMenuService {
    boolean saveRoleMenuAll(List<RoleMenuPo> roleMenuPos);

    /**
     * 根据角色id，删除此角色下面的所有菜单
     * @param roleId
     * @return
     */
    Boolean deleteByRoleId(Long roleId);

    List<RoleMenuPo> getMenuByRoleId(Long roleId);
}
