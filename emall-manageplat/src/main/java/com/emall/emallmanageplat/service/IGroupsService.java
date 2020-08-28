package com.emall.emallmanageplat.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.GroupParam;
import com.emall.emallweb.entity.po.GroupsPo;
import com.emall.emallmanageplat.entity.vo.GroupVo;

/**
 * <p>
 * 用户组表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IGroupsService {

    /**
     * 添加用户组
     * @param groupsPo
     * @return
     */
    boolean insertGroup(GroupsPo groupsPo);

    /**
     * 更新用户组信息
     * @param groupsPo
     * @return
     */
    boolean updateGroup(GroupsPo groupsPo);

    /**
     * 删除用户组信息
     * @param id
     * @return
     */
    boolean deleteGroup(String id);

    /**
     * 条件查询用户组
     * @param page
     * @param groupParam
     * @return
     */
    IPage<GroupVo> getGroup(Page page, GroupParam groupParam);
}
