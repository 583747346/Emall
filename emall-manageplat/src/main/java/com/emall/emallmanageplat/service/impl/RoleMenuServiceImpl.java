package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallweb.entity.po.RoleMenuPo;
import com.emall.emallmanageplat.mapper.RoleMenuMapper;
import com.emall.emallmanageplat.service.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenuPo> implements IRoleMenuService {
    /**
     * 批量保存角色菜单信息
     *
     * @param roleMenuPos
     * @return
     */
    @Override
    @Transactional
    public boolean saveBatch(List<RoleMenuPo> roleMenuPos) {
        return this.saveBatch(roleMenuPos);
    }

    /**
     * 根据角色id，删除角色下面的所有菜单信息
     * @param roleId
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteByRoleId(Long roleId) {
        QueryWrapper<RoleMenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        return this.remove(queryWrapper);
    }
}
