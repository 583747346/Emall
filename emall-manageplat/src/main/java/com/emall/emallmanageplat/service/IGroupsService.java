package com.emall.emallmanageplat.service;


import com.emall.emallmanageplat.entity.params.GroupQueryParam;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import com.emall.emallmanageplat.entity.vo.GroupVo;

import java.util.List;

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
     * @param groupQueryParam
     * @return
     */
    List<GroupVo> getGroup(GroupQueryParam groupQueryParam);
}
