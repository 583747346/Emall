package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallweb.entity.po.UserRolePo;
import com.emall.emallmanageplat.mapper.UserRoleMapper;
import com.emall.emallmanageplat.service.IUsersRolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersRolesServiceImpl extends ServiceImpl<UserRoleMapper, UserRolePo> implements IUsersRolesService {
    /**
     * 根据用户id，查询该用户的角色
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Long> queryByUserId(Long userId) {
        QueryWrapper<UserRolePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserRolePo> userRolePoList = list(queryWrapper);
        return userRolePoList.stream().map(UserRolePo::getRoleId).collect(Collectors.toSet());
    }

    /**
     * 批量保存用户角色信息
     *
     * @param poList
     * @return
     */
    @Override
    @Transactional
    public boolean saveAll(List<UserRolePo> poList) {
        return this.saveBatch(poList);
    }

    /**
     * 根据用户id，删除改用户相关角色信息
     * @param userId
     * @return
     */
    @Override
    public boolean deleteRolesByUseridId(Long userId) {
        QueryWrapper<UserRolePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return this.remove(queryWrapper);
    }
}
