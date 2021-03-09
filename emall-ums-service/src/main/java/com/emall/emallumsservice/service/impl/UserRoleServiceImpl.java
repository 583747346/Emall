package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.po.UserRolePo;
import com.emall.emallumsservice.mapper.UserRoleMapper;
import com.emall.emallumsservice.service.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRolePo> implements IUserRoleService {
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
     * @param userId
     * @param roleIds
     * @return
     */
    @Override
    @Transactional
    public boolean saveAll(Long userId, List<Long> roleIds) {
        //先删除该用户所有角色信息
        QueryWrapper<UserRolePo> wrapperForDelete = new QueryWrapper<>();
        wrapperForDelete.eq("user_id", userId);
        this.baseMapper.delete(wrapperForDelete);
        //为用户添加新的角色
        List<UserRolePo> userRolePos = new ArrayList<>();
        for (Long roleId : roleIds) {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(userId);
            userRolePo.setRoleId(roleId);
            userRolePos.add(userRolePo);
        }
        return this.saveBatch(userRolePos);
    }

    /**
     * 根据用户id，删除改用户相关角色信息
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteRolesByUseridId(Long userId) {
        QueryWrapper<UserRolePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.remove(queryWrapper);
    }
}
