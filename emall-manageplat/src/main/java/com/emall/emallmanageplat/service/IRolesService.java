package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.po.RolesPo;
import com.emall.emallmanageplat.entity.vo.RolesVo;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IRolesService {

    List<RolesVo> getRole(String userId);

    boolean deleteRole(String roleId);

    boolean updateRole(RolesPo rolesPo);

    boolean insertRole(RolesPo rolesPo);
}
