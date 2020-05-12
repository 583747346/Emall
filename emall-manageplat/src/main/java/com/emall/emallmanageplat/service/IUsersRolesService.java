package com.emall.emallmanageplat.service;

import java.util.Set;

public interface IUsersRolesService {
    Set<String> queryByUserId(String userId);
}
