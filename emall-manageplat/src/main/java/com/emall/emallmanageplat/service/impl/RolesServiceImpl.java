package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallweb.entity.po.RoleMenuPo;
import com.emall.emallweb.entity.po.RoleResourcePo;
import com.emall.emallweb.entity.po.RolesPo;
import com.emall.emallmanageplat.entity.vo.RolesVo;
import com.emall.emallmanageplat.mapper.RolesMapper;
import com.emall.emallmanageplat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, RolesPo> implements IRolesService {

    @Autowired
    private IUsersRolesService usersRolesService;

    @Autowired
    private IRoleResourceService roleResourceService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IRoleMenuService roleMenuService;

    /**
     * 根据用户id查询角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<RolesVo> getRole(Long userId) {
        Set<Long> roleIds = usersRolesService.queryByUserId(userId);
        return this.listByIds(roleIds).stream().map(RolesVo::new).collect(Collectors.toList());
    }

    /**
     * 删除角色信息
     * 删除此角色下面的资源信息
     *
     * @param roleId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteRole(Long roleId) {
        boolean flag = roleResourceService.deleteByRoleId(roleId);
        return this.deleteRole(roleId);
    }

    /**
     * 更新角色信息
     *
     * @param rolesPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateRole(RolesPo rolesPo) {
        //更新角色信息
        boolean flag_role = this.updateById(rolesPo);
        return flag_role;
    }

    /**
     * 添加角色信息
     *
     * @param rolesPo
     * @return
     */
    @Override
    @Transactional
    public boolean insertRole(RolesPo rolesPo) {
        boolean flag_role = this.save(rolesPo);
        return flag_role;
    }

    /**
     * 为此角色，分配菜单信息
     *
     * @param roleId
     * @param menuId
     * @return
     */
    @Override
    @Transactional
    public boolean updateMenuByRoleId(Long roleId, String menuId) {
        //先删除此角色表里面的数据
        Boolean roleMenuDel = roleMenuService.deleteByRoleId(roleId);
        //保存相关 角色-菜单数据 到角色-菜单关系表
        List<RoleMenuPo> roleMenuPos = new ArrayList<>();
        Arrays.stream(menuId.split(",")).forEach(id -> {
            RoleMenuPo roleMenuPo = new RoleMenuPo();
            roleMenuPo.setMenuId(Long.parseLong(id));
            roleMenuPo.setRoleId(roleId);
            roleMenuPos.add(roleMenuPo);
        });
        boolean roleMenuAdd = roleMenuService.saveBatch(roleMenuPos);
        return roleMenuDel && roleMenuAdd;
    }

    /**
     * 为此角色分配资源信息
     *
     * @param roleId
     * @param resourceId
     * @return
     */
    @Override
    @Transactional
    public boolean updateResourceByRoleId(Long roleId, String resourceId) {
        //先删除此角色下面的所有资源信息
        boolean roleResourceDel = roleResourceService.deleteByRoleId(roleId);
        //保存相关 角色-菜单数据 到角色-菜单关系表
        List<RoleResourcePo> roleResourcePos = new ArrayList<>();
        Arrays.stream(resourceId.split(",")).forEach(id -> {
            RoleResourcePo roleMenuPo = new RoleResourcePo();
            roleMenuPo.setResourceId(Long.parseLong(id));
            roleMenuPo.setRoleId(roleId);
            roleResourcePos.add(roleMenuPo);
        });
        boolean roleResourceAdd = roleResourceService.saveBatch(roleResourcePos);
        return roleResourceDel && roleResourceAdd;
    }
}
