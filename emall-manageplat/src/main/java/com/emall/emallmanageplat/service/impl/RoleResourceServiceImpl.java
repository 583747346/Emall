package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.RoleResourcePo;
import com.emall.emallmanageplat.mapper.RoleResourceMapper;
import com.emall.emallmanageplat.service.IRoleResourceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper,RoleResourcePo> implements IRoleResourceService {
    @Override
    public boolean deleteByRoleId(String roleId) {
        return false;
    }

    @Override
    public boolean saveBatch(String id, Set<String> resourceIds) {
        return false;
    }
}
