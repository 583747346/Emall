package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.po.UserRolePo;

import java.util.List;
import java.util.Set;

public interface IUsersRolesService {
    Set<Long> queryByUserId(Long userId);

    boolean saveAll(List<UserRolePo> poList);

    boolean deleteRolesByUseridId(Long userId);
}
