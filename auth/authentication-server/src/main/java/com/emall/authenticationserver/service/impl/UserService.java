package com.emall.authenticationserver.service.impl;


import com.emall.authenticationserver.entity.User;
import com.emall.authenticationserver.provider.OrganizationProvider;
import com.emall.authenticationserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private OrganizationProvider organizationProvider;

    @Override
    public User getByUniqueId(String uniqueId) {
        return organizationProvider.getUserByUniqueId(uniqueId).getData();
    }
}
