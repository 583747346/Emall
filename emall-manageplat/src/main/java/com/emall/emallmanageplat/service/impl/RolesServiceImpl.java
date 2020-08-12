package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.RolesPo;
import com.emall.emallmanageplat.entity.vo.RolesVo;
import com.emall.emallmanageplat.mapper.RolesMapper;
import com.emall.emallmanageplat.service.IResourceService;
import com.emall.emallmanageplat.service.IRoleResourceService;
import com.emall.emallmanageplat.service.IRolesService;
import com.emall.emallmanageplat.service.IUsersRolesService;
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
public class RolesServiceImpl extends ServiceImpl<RolesMapper, RolesPo> implements IRolesService {

    @Autowired
    private IUsersRolesService usersRolesService;

    @Autowired
    private IRoleResourceService roleResourceService;

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
     * 更新此角色下面的资源信息
     *
     * @param rolesPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateRole(RolesPo rolesPo) {
        //更新角色信息
        boolean flag_role = this.updateById(rolesPo);
        //批量更新此角色下面的资源信息
        boolean flag_resource = roleResourceService.saveBatch(String.valueOf(rolesPo.getId()), rolesPo.getResourceIds());
        return flag_role && flag_resource;
    }

    /**
     * 添加角色信息
     * 角色添加资源信息
     *
     * @param rolesPo
     * @return
     */
    @Override
    @Transactional
    public boolean insertRole(RolesPo rolesPo) {
        boolean flag_role = this.save(rolesPo);
        //批量添加该角色下的资源
        boolean flag_resource = roleResourceService.saveBatch(String.valueOf(rolesPo.getId()), rolesPo.getResourceIds());
        return flag_role && flag_resource;
    }
}
