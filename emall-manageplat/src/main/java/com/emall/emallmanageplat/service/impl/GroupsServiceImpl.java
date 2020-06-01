package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.GroupParam;
import com.emall.emallmanageplat.entity.params.GroupQueryParam;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import com.emall.emallmanageplat.entity.vo.GroupVo;
import com.emall.emallmanageplat.mapper.GroupsMapper;
import com.emall.emallmanageplat.service.IGroupsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return this.save(groupsPo);
    }

    @Override
    @Transactional
    public boolean updateGroup(GroupsPo groupsPo) {
        return this.save(groupsPo);
    }

    @Override
    @Transactional
    public boolean deleteGroup(String id) {
        GroupsPo groupsPo = this.getById(id);
        groupsPo.setDeleted("1");
        return this.updateById(groupsPo);
    }

    /**
     * 条件分页查询用户组
     * @param page
     * @param groupParam
     * @return
     */
    @Override
    public List<GroupVo> getGroup(Page page, GroupParam groupParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(groupParam.getName()), "name", groupParam.getName());
        queryWrapper.ge("created_by", groupParam.getCreatedTimeStart());
        queryWrapper.le("created_by", groupParam.getCreatedTimeEnd());
        List<GroupsPo> groupsPos = this.baseMapper.selectList(queryWrapper);
        List<GroupVo> groupVos = new ArrayList<>();
        groupsPos.stream().forEach(groupsPo -> {
            GroupVo groupVo = new GroupVo();
            groupVo.toVo(groupsPo);
            groupVos.add(groupVo);
        });
        return groupVos;
    }

}
