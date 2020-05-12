package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.UserRoleRelation;
import com.emall.emallmanageplat.mapper.UserRoleMapper;
import com.emall.emallmanageplat.service.IUsersRolesService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersRolesServiceImpl extends ServiceImpl<UserRoleMapper,UserRoleRelation> implements IUsersRolesService {
    @Override
    public Set<String> queryByUserId(String userId) {
        QueryWrapper<UserRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserRoleRelation> userRoleRelationList = list(queryWrapper);
        return userRoleRelationList.stream().map(UserRoleRelation::getRoleId).collect(Collectors.toSet());
    }
}
