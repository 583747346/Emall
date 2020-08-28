package com.emall.emallmanageplat.service;

import com.emall.emallweb.entity.po.RolesPo;
import com.emall.emallmanageplat.entity.vo.RolesVo;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IRolesService {

    List<RolesVo> getRole(Long userId);

    boolean deleteRole(Long roleId);

    boolean updateRole(RolesPo rolesPo);

    boolean insertRole(RolesPo rolesPo);

    /**
     * 根据角色id  为此角色分配菜单信息
     *
     * @param roleId
     * @param menuId
     * @return
     */
    boolean updateMenuByRoleId(Long roleId, String menuId);

    /**
     * 根据角色id   为此角色分配资源信息
     *
     * @param roleId
     * @param resourceId
     * @return
     */
    boolean updateResourceByRoleId(Long roleId, String resourceId);


}
