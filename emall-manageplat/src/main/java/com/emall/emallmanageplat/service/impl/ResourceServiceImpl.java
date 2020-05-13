package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.Resource;
import com.emall.emallmanageplat.mapper.ResourceMapper;
import com.emall.emallmanageplat.service.IResourceService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

    @Override
    public Set<Resource> getResourceByUsername(String username) {
        return null;
    }
}
