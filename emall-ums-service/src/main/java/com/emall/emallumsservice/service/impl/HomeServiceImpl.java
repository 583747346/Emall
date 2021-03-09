package com.emall.emallumsservice.service.impl;


import com.emall.emallumsentity.entity.vo.HomeMenuVo;
import com.emall.emallumsentity.entity.vo.PermissionVo;
import com.emall.emallumsentity.entity.vo.UserVo;
import com.emall.emallumsservice.mapper.HomeMapper;
import com.emall.emallumsservice.service.IHomeService;
import com.emall.emallumsservice.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private IUserService usersService;
    @Autowired
    private HomeMapper homeMapper;
    /**
     * 获取管理平台左侧菜单
     * @param username
     * @return
     */
    @Override
    public List<PermissionVo> treeList(String username) {
        //获取当前用户
        UserVo user = usersService.getByUniqueId(username);
        //获取当前用户的菜单权限
        List<HomeMenuVo> homeMenus = homeMapper.listPermission(user.getId());
        List<PermissionVo> result = homeMenus.stream()
                .filter(homeMenu -> homeMenu.getParentId().equals(0L))   //parentId为0 -> 父菜单
                .map(permission -> convert(permission, homeMenus)).collect(Collectors.toList());
        return result;
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private PermissionVo convert(HomeMenuVo homeMenuVo, List<HomeMenuVo> homeMenus) {
        PermissionVo node = new PermissionVo();
        BeanUtils.copyProperties(homeMenuVo, node);
        List<PermissionVo> children = homeMenus.stream()
                .filter(subHomeMenu -> subHomeMenu.getParentId().equals(homeMenuVo.getMenuId()))
                .map(subHomeMenu -> convert(subHomeMenu, homeMenus)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
