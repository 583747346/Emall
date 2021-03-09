package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.params.GroupParam;
import com.emall.emallumsentity.entity.po.GroupPo;
import com.emall.emallumsentity.entity.vo.GroupVo;
import com.emall.emallumsservice.mapper.GroupMapper;
import com.emall.emallumsservice.service.IGroupsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户组表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class GroupsServiceImpl extends ServiceImpl<GroupMapper, GroupPo> implements IGroupsService {

    @Override
    @Transactional
    public boolean insertGroup(GroupPo groupsPo) {
        return this.save(groupsPo);
    }

    @Override
    @Transactional
    public boolean updateGroup(GroupPo groupsPo) {
        return this.save(groupsPo);
    }

    @Override
    @Transactional
    public boolean deleteGroup(String id) {
        GroupPo groupsPo = this.getById(id);
        groupsPo.setDeleted("Y");
        return this.updateById(groupsPo);
    }

    /**
     * 条件分页查询用户组
     *
     * @param page
     * @param groupParam
     * @return
     */
    @Override
    public IPage<GroupVo> getGroup(Page page, GroupParam groupParam) {
        QueryWrapper queryWrapper = groupParam.build().like(StringUtils.isNotEmpty(groupParam.getName()), "name", groupParam.getName());
        IPage<GroupPo> groupsPos = this.page(page, queryWrapper);
        return groupsPos.convert(GroupVo::new);
    }

}
