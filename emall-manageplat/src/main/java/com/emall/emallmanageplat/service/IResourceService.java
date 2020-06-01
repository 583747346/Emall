package com.emall.emallmanageplat.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.ResourceParam;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import com.emall.emallmanageplat.entity.vo.ResourceVo;

import java.util.List;
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
    List<ResourcePo> getResourceByUsername(String username);

    /**
     * 分页查询所有资源信息
     * @param page
     * @param resourceParam
     * @return
     */
    IPage<ResourceVo> getResources(Page page, ResourceParam resourceParam);

    /**
     * 添加资源
     * @param resourcePo
     * @return
     */
    boolean insertResources(ResourcePo resourcePo);

    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    boolean deleteResources(String resourceId);

    /**
     * 更新资源
     * @param toPo
     * @return
     */
    boolean updateResource(ResourcePo resourcePo);
}
