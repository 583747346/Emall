package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.po.RolesPo;

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

    List<RolesPo> query(String userId);
}
