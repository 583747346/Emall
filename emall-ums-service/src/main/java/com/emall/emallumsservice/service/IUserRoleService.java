package com.emall.emallumsservice.service;

import java.util.List;
import java.util.Set;

public interface IUserRoleService {
    Set<Long> queryByUserId(Long userId);

    boolean saveAll(Long id, List<Long> roleIds);

    boolean deleteRolesByUseridId(Long userId);
}
