package com.emall.emallmanageplat.service;


import com.emall.emallmanageplat.entity.po.ResourcePo;

import java.util.Set;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IResourceService {

    /**
     * 根据用户名获取用户角色的资源信息
     * @param username
     * @return
     */
    Set<ResourcePo> getResourceByUsername(String username);
}
