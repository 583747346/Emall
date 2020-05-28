package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.RolesPo;
import com.emall.emallmanageplat.mapper.RolesMapper;
import com.emall.emallmanageplat.service.IRolesService;
import com.emall.emallmanageplat.service.IUsersRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<RolesPo> query(String userId) {
        Set<String> roleIds = usersRolesService.queryByUserId(userId);
        return (List<RolesPo>) this.listByIds(roleIds);
    }
}
