package com.emall.emallumsservice.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallumsentity.entity.params.ResourceParam;
import com.emall.emallumsentity.entity.po.ResourcePo;
import com.emall.emallumsentity.entity.vo.ResourceTreeVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;

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
    boolean deleteResources(Long resourceId);

    /**
     * 更新资源
     * @param resourcePo
     * @return
     */
    boolean updateResource(ResourcePo resourcePo);


    /**
     * 查询所有资源信息
     * 资源服务器（authorization-server）启动时加载所有资源
     * @return
     */
    List<ResourcePo> getAll();

    /**
     * 根据资源ids结合查看资源信息
     * @param list
     * @return
     */
    Set<ResourceVo> getResourceByIds(List<Long> list);

    List<String> getMethods();

    List<String> getTypes();

    List<ResourceTreeVo> getResourceTree();
}
