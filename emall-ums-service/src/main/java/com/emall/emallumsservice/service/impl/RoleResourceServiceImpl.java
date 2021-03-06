package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.po.RoleResourcePo;
import com.emall.emallumsservice.mapper.RoleResourceMapper;
import com.emall.emallumsservice.service.IRoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResourcePo> implements IRoleResourceService {
    /**
     * 根据角色id，删除角色资源
     *
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteByRoleId(Long roleId) {
        QueryWrapper<RoleResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        return this.remove(queryWrapper);
    }

    @Override
    @Transactional
    public boolean saveAll(String id, Set<String> resourceIds) {
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

    @Override
    @Transactional
    public boolean saveRoleResourceAll(List<RoleResourcePo> roleResourcePos) {
        return this.saveBatch(roleResourcePos);
    }

    /**
     * 根据角色id查看资源信息列表
     *
     * @param roleId
     * @return
     */
    @Override
    public List<RoleResourcePo> getResourceByRoleId(Long roleId) {
        QueryWrapper<RoleResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleId);
        return this.baseMapper.selectList(queryWrapper);
    }
}
