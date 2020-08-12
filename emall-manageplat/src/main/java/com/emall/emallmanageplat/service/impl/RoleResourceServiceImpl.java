package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.RoleResourcePo;
import com.emall.emallmanageplat.mapper.RoleResourceMapper;
import com.emall.emallmanageplat.service.IRoleResourceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResourcePo> implements IRoleResourceService {
    /**
     * 根据角色id，删除角色资源
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteByRoleId(Long roleId) {
        return false;
    }

    @Override
    public boolean saveBatch(String id, Set<String> resourceIds) {
        return false;
    }

    /**
     * 根据角色列表查询到角色的资源的关联关系
     *
     * @param roleIds
     * @return
     */
    @Override
    public List<RoleResourcePo> queryByRoleIds(Set<Long> roleIds) {
        QueryWrapper<RoleResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        return this.list(queryWrapper);
    }
}
