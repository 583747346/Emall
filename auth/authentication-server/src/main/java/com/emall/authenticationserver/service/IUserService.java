package com.emall.authenticationserver.service;

import com.emall.authenticationserver.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

public interface IUserService {

    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param uniqueId
     * @return
     */
    @Cacheable(value = "#id")
    User getByUniqueId(String uniqueId);
}
