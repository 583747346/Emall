package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.config.BusConfig;
import com.emall.emallmanageplat.entity.params.ResourceParam;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import com.emall.emallmanageplat.entity.po.RoleResourcePo;
import com.emall.emallmanageplat.entity.vo.ResourceVo;
import com.emall.emallmanageplat.entity.vo.RolesVo;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.mapper.ResourceMapper;
import com.emall.emallmanageplat.rabbit.ResourceMessage;
import com.emall.emallmanageplat.rabbit.event.ResouorceEventSender;
import com.emall.emallmanageplat.service.IResourceService;
import com.emall.emallmanageplat.service.IRoleResourceService;
import com.emall.emallmanageplat.service.IRolesService;
import com.emall.emallmanageplat.service.IUsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
@RefreshScope
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourcePo> implements IResourceService {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IRoleResourceService roleResourceService;
    @Autowired
    private ResouorceEventSender resouorceEventSender;

    @Override
    public List<ResourcePo> getResourceByUsername(String username) {
        //根据用户名查询到用户所拥有的角色
        UsersVo usersVo = usersService.getByUniqueId(username);
        //获取角色
        List<RolesVo> rolesVo = rolesService.getRole(usersVo.getId());
        //提取用户所拥有角色id列表
        Set<Long> roleIds = rolesVo.stream().map(role -> role.getId()).collect(Collectors.toSet());
        //根据角色列表查询到角色的资源的关联关系
        List<RoleResourcePo> roleResourcePos = roleResourceService.queryByRoleIds(roleIds);
        //根据资源列表查询出所有资源对象
        Set<Long> resourceIds = roleResourcePos.stream().map(roleResourcePo -> roleResourcePo.getResourceId()).collect(Collectors.toSet());
        //根据resourceId列表查询出resource信息
        List<ResourcePo> resourcePos = (List<ResourcePo>) this.listByIds(resourceIds);
        return resourcePos;
    }

    /**
     * 分页查询资源信息
     *
     * @param page
     * @param resourceParam
     * @return
     */
    @Override
    public IPage<ResourceVo> getResources(Page page, ResourceParam resourceParam) {
        QueryWrapper<ResourcePo> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.equals(resourceParam.getName(), ""), "name", resourceParam.getName());
        queryWrapper.eq(StringUtils.equals(resourceParam.getMethod(), ""), "method", resourceParam.getMethod());
        queryWrapper.eq(StringUtils.equals(resourceParam.getType(), ""), "type", resourceParam.getType());
        IPage<ResourcePo> resourcePos = this.page(page, queryWrapper);
        return resourcePos.convert(ResourceVo::new);
    }

    /**
     * 添加一个新的资源
     *
     * @param resourcePo
     * @return
     */
    @Override
    @Transactional
    public boolean insertResources(ResourcePo resourcePo) {
        //添加的资源信息加入rabbitmq
        ResourceMessage resourceMessage = new ResourceMessage(resourcePo);
        //0-代表新添操作
        resourceMessage.setFlag(true);
        resouorceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourceMessage);
        boolean success = this.save(resourcePo);
        return success;
    }

    /**
     * 删除资源
     *
     * @param resourceId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteResources(Long resourceId) {
        ResourcePo resourcePo = this.getById(resourceId);
        //删除资源的消息发送到rabbitmq
        ResourceMessage resourceMessage = new ResourceMessage(resourcePo);
        //2-代表删除操作
        resourceMessage.setFlag(false);
        resouorceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourcePo);
        return this.removeById(resourceId);
    }

    /**
     * 更新资源
     *
     * @param resourcePo
     * @return
     */
    @Override
    @Transactional
    public boolean updateResource(ResourcePo resourcePo) {
        //删除资源的消息发送到rabbitmq
        ResourceMessage resourceMessage = new ResourceMessage(resourcePo);
        //1-代表更新操作
        resourceMessage.setFlag(true);
        resouorceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourcePo);
        return this.updateById(resourcePo);
    }

    /**
     * 查询所有资源信息
     *
     * @return
     */
    @Override
    public List<ResourcePo> getAll() {
        return this.list();
    }
}
