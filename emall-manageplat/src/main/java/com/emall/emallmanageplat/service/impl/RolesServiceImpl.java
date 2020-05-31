package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.RolesPo;
import com.emall.emallmanageplat.mapper.RolesMapper;
import com.emall.emallmanageplat.service.IResourceService;
import com.emall.emallmanageplat.service.IRoleResourceService;
import com.emall.emallmanageplat.service.IRolesService;
import com.emall.emallmanageplat.service.IUsersRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
     * 查询角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<RolesPo> getRole(String userId) {
        Set<String> roleIds = usersRolesService.queryByUserId(userId);
        return (List<RolesPo>) this.listByIds(roleIds);
    }

    /**
     * 删除角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteRole(String roleId) {
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
        //批量更新此角色下面的资源信息
        boolean flag_resource = roleResourceService.saveBatch(rolesPo.getId(),rolesPo.getResourceIds());
        return flag_role && flag_resource;
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
        boolean flag_resource = roleResourceService.saveBatch(rolesPo.getId(), rolesPo.getResourceIds());
        return flag_role && flag_resource;
    }
}
