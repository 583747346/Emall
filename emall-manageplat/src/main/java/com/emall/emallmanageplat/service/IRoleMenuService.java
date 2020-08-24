package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.po.RoleMenuPo;

import java.util.List;

public interface IRoleMenuService {
    boolean saveBatch(List<RoleMenuPo> roleMenuPos);

    /**
     * 根据角色id，删除此角色下面的所有菜单
     * @param roleId
     * @return
     */
    Boolean deleteByRoleId(Long roleId);
}
