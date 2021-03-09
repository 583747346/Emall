package com.emall.emallumsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallumsentity.entity.params.RolePageParam;
import com.emall.emallumsentity.entity.po.RolePo;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;
import com.emall.emallumsentity.entity.vo.RoleVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IRoleService {

    List<RoleVo> getRole(Long userId);

    boolean deleteRole(Long roleId);

    boolean updateRole(RolePo rolePo);

    boolean insertRole(RolePo rolePo);

    /**
     * 根据角色id  为此角色分配菜单信息
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean updateMenuByRoleId(Long roleId, List<String> menuIds);

    /**
     * 根据角色id   为此角色分配资源信息
     *
     * @param roleId
     * @param resourceIds
     * @return
     */
    boolean updateResourceByRoleId(Long roleId, List<String> resourceIds);


    IPage<RoleVo> getRoleList(RolePageParam rolePageParam);

    Set<RoleVo> getRoles();

    Set<MenuVo> getMenuByRoleId(Long roleId);

    Set<ResourceVo> getResourceByRoleId(Long roleId);
}
