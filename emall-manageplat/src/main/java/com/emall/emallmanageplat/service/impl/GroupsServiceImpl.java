package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.GroupParam;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import com.emall.emallmanageplat.entity.vo.GroupVo;
import com.emall.emallmanageplat.mapper.GroupsMapper;
import com.emall.emallmanageplat.service.IGroupsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户组表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class GroupsServiceImpl extends ServiceImpl<GroupsMapper, GroupsPo> implements IGroupsService {

    @Override
    @Transactional
    public boolean insertGroup(GroupsPo groupsPo) {
        return this.save (groupsPo);
    }

    @Override
    @Transactional
    public boolean updateGroup(GroupsPo groupsPo) {
        return this.save (groupsPo);
    }

    @Override
    @Transactional
    public boolean deleteGroup(String id) {
        GroupsPo groupsPo = this.getById (id);
        groupsPo.setDeleted ("1");
        return this.updateById (groupsPo);
    }

    @Override
    public List<GroupVo> getGroup(GroupParam groupParam) {
        QueryWrapper queryWrapper = new QueryWrapper ();
        //TODO 获取用户组信息
        return null;
    }

}
