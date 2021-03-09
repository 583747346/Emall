package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.params.RolePageParam;
import com.emall.emallumsentity.entity.po.RoleMenuPo;
import com.emall.emallumsentity.entity.po.RolePo;
import com.emall.emallumsentity.entity.po.RoleResourcePo;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;
import com.emall.emallumsentity.entity.vo.RoleVo;
import com.emall.emallumsservice.mapper.RolesMapper;
import com.emall.emallumsservice.service.*;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class RoleServiceImpl extends ServiceImpl<RolesMapper, RolePo> implements IRoleService {

    @Autowired
    private IUserRoleService usersRolesService;

    @Autowired
    private IRoleResourceService roleResourceService;

    @Autowired
    private IRoleMenuService roleMenuService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IResourceService resourceService;

    /**
     * 根据用户id查询角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<RoleVo> getRole(Long userId) {
        Set<Long> roleIds = usersRolesService.queryByUserId(userId);
        return this.listByIds(roleIds).stream().map(rolePo -> new RoleVo(rolePo)).collect(Collectors.toList());
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
     * @param rolePo
     * @return
     */
    @Override
    @Transactional
    public boolean updateRole(RolePo rolePo) {
        //更新角色信息
        boolean flag_role = this.updateById(rolePo);
        return flag_role;
    }

    /**
     * 添加角色信息
     *
     * @param rolePo
     * @return
     */
    @Override
    @Transactional
    public boolean insertRole(RolePo rolePo) {
        boolean flag_role = this.save(rolePo);
        return flag_role;
    }

    /**
     * 为此角色，分配菜单信息
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    @Override
    @Transactional
    public boolean updateMenuByRoleId(Long roleId, List<String> menuIds) {
        //先删除此角色表里面的数据
        Boolean roleMenuDel = roleMenuService.deleteByRoleId(roleId);
        //保存相关 角色-菜单数据 到角色-菜单关系表
        List<RoleMenuPo> roleMenuPos = new ArrayList<>();
        menuIds.forEach(id -> {
            RoleMenuPo roleMenuPo = new RoleMenuPo();
            roleMenuPo.setMenuId(Long.parseLong(id));
            roleMenuPo.setRoleId(roleId);
            roleMenuPos.add(roleMenuPo);
        });
        boolean roleMenuAdd = roleMenuService.saveRoleMenuAll(roleMenuPos);
        return roleMenuDel && roleMenuAdd;
    }

    /**
     * 为此角色分配资源信息
     *
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Override
    @Transactional
    public boolean updateResourceByRoleId(Long roleId, List<String> resourceIds) {
        //先删除此角色下面的所有资源信息
        boolean roleResourceDel = roleResourceService.deleteByRoleId(roleId);
        //保存相关 角色-菜单数据 到角色-菜单关系表
        List<RoleResourcePo> roleResourcePos = new ArrayList<>();
        resourceIds.forEach(id -> {
            RoleResourcePo roleMenuPo = new RoleResourcePo();
            roleMenuPo.setResourceId(Long.parseLong(id));
            roleMenuPo.setRoleId(roleId);
            roleResourcePos.add(roleMenuPo);
        });
        boolean roleResourceAdd = roleResourceService.saveRoleResourceAll(roleResourcePos);
        return roleResourceDel && roleResourceAdd;
    }

    @Override
    public IPage<RoleVo> getRoleList(RolePageParam rolePageParam) {
        QueryWrapper<RolePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(rolePageParam.getName()), "name", rolePageParam.getName());
        IPage<RolePo> page = this.page(rolePageParam.getPage(), queryWrapper);
        return page.convert(RoleVo::new);
    }

    @Override
    public Set<RoleVo> getRoles() {
        List<RolePo> roles = this.list();
        return roles.stream().map(role -> new RoleVo(role)).collect(Collectors.toSet());
    }

    /**
     * 根据角色id查看菜单信息
     *
     * @param roleId
     * @return
     */
    @Override
    public Set<MenuVo> getMenuByRoleId(Long roleId) {
        List<RoleMenuPo> roleMenuPos = roleMenuService.getMenuByRoleId(roleId);
        List<Long> list = roleMenuPos.stream().map(roleMenuPo -> roleMenuPo.getMenuId()).collect(Collectors.toList());
        Set<MenuVo> menuVos = menuService.getMenuByIds(list);
        return menuVos.stream().collect(Collectors.toSet());
    }

    /**
     * 根据角色id查看资源信息
     *
     * @param roleId
     * @return
     */
    @Override
    public Set<ResourceVo> getResourceByRoleId(Long roleId) {
        List<RoleResourcePo> roleResourcePos = roleResourceService.getResourceByRoleId(roleId);
        List<Long> list = roleResourcePos.stream().map(roleResourcePo -> roleResourcePo.getResourceId()).collect(Collectors.toList());
        if (list == null || list.size() == 0) {
            return Sets.newHashSet();
        }
        Set<ResourceVo> resourceVos = resourceService.getResourceByIds(list);
        return resourceVos;
    }
}
