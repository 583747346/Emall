package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.params.ResourceParam;
import com.emall.emallumsentity.entity.po.ResourcePo;
import com.emall.emallumsentity.entity.po.RoleResourcePo;
import com.emall.emallumsentity.entity.vo.ResourceTreeVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;
import com.emall.emallumsentity.entity.vo.RoleVo;
import com.emall.emallumsentity.entity.vo.UserVo;
import com.emall.emallumsservice.config.BusConfig;
import com.emall.emallumsservice.mapper.ResourceMapper;
import com.emall.emallumsservice.rabbit.ResourceMessage;
import com.emall.emallumsservice.rabbit.event.ResourceEventSender;
import com.emall.emallumsservice.service.IResourceService;
import com.emall.emallumsservice.service.IRoleResourceService;
import com.emall.emallumsservice.service.IRoleService;
import com.emall.emallumsservice.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
    private IUserService usersService;
    @Autowired
    private IRoleService rolesService;
    @Autowired
    private IRoleResourceService roleResourceService;
    @Autowired
    private ResourceEventSender resourceEventSender;

    @Override
    public List<ResourcePo> getResourceByUsername(String username) {
        //根据用户名查询到用户所拥有的角色
        UserVo userVo = usersService.getByUniqueId(username);
        //获取角色
        List<RoleVo> roleVo = rolesService.getRole(userVo.getId());
        //提取用户所拥有角色id列表
        Set<Long> roleIds = roleVo.stream().map(role -> role.getId()).collect(Collectors.toSet());
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
        queryWrapper.like(StringUtils.isNotBlank(resourceParam.getName()), "name", resourceParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(resourceParam.getMethod()), "method", resourceParam.getMethod());
        queryWrapper.eq(StringUtils.isNotBlank(resourceParam.getType()), "type", resourceParam.getType());
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
        ResourceMessage resourceMessage = new ResourceMessage();
        BeanUtils.copyProperties(resourcePo,resourceMessage);
        //0-代表新添操作
        resourceMessage.setFlag(true);
        resourceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourceMessage);
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
        ResourceMessage resourceMessage = new ResourceMessage();
        BeanUtils.copyProperties(resourcePo,resourceMessage);
        //2-代表删除操作
        resourceMessage.setFlag(false);
        resourceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourceMessage);
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
        //更新资源的消息发送到rabbitmq
        ResourceMessage resourceMessage = new ResourceMessage();
        BeanUtils.copyProperties(resourcePo,resourceMessage);
        //1-代表更新操作
        resourceMessage.setFlag(true);
        resourceEventSender.send(BusConfig.RESOURCE_BINDING_NAME, resourceMessage);
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

    /**
     * 根据资源ids查看资源信息
     *
     * @param list
     * @return
     */
    @Override
    public Set<ResourceVo> getResourceByIds(List<Long> list) {
        QueryWrapper<ResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", list);
        Set<ResourceVo> resourceVos = this.baseMapper.selectList(queryWrapper).stream().map(resourcePo -> new ResourceVo(resourcePo)).collect(Collectors.toSet());
        return resourceVos;
    }

    @Override
    public List<String> getMethods() {
        QueryWrapper<ResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct method");
        return this.list(queryWrapper).stream().map(resourcePo -> resourcePo.getMethod()).collect(Collectors.toList());
    }

    @Override
    public List<String> getTypes() {
        QueryWrapper<ResourcePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct type");
        return this.list(queryWrapper).stream().map(resourcePo -> resourcePo.getType()).collect(Collectors.toList());
    }

    @Override
    public List<ResourceTreeVo> getResourceTree() {
        List<ResourcePo> list = this.list();
        List<ResourceTreeVo> resourceTreeVos = list.stream().map(resourcePo -> new ResourceTreeVo(resourcePo)).sorted(Comparator.comparing(ResourceTreeVo::getType)).collect(Collectors.toList());
        List<ResourceTreeVo> treeVos = new ArrayList<>();
        //按照资源type分组
        Map<String, List<ResourceTreeVo>> collect = resourceTreeVos.stream().collect(Collectors.groupingBy(resource -> resource.getType()));
        collect.forEach((key, value) -> {
            ResourceTreeVo treeVo = new ResourceTreeVo();
            treeVo.setType(key);
            treeVo.setChildren(value);
            treeVos.add(treeVo);
        });
        return treeVos.stream().sorted(Comparator.comparing(ResourceTreeVo::getType)).collect(Collectors.toList());
    }


}
