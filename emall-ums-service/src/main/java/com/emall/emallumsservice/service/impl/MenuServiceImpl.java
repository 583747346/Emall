package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.form.MenuForm;
import com.emall.emallumsentity.entity.params.MenuPageParam;
import com.emall.emallumsentity.entity.po.MenuPo;
import com.emall.emallumsentity.entity.vo.HomeMenuVo;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.PermissionVo;
import com.emall.emallumsservice.mapper.MenuMapper;
import com.emall.emallumsservice.oss.OssUploadPicture;
import com.emall.emallumsservice.service.IMenuService;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPo> implements IMenuService {

    @Resource
    private OssUploadPicture ossUploadPicture;

    /**
     * 新添菜单信息
     *
     * @param menuForm
     * @return
     */
    @Override
    @Transactional
    public Boolean insertMenu(MenuForm menuForm) {
        MenuPo menuPo = menuForm.toPo(MenuPo.class);
        return this.save(menuPo);
    }

    /**
     * 删除菜单信息
     *
     * @param menuId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteMenu(Long menuId) {
        return this.removeById(menuId);
    }

    /**
     * 更新菜单信息
     *
     * @param menuId
     * @param menuForm
     * @return
     */
    @Override
    @Transactional
    public boolean updateMenu(Long menuId, MenuForm menuForm) {
        MenuPo menuPo = menuForm.toPo(menuId, MenuPo.class);
        return this.updateById(menuPo);
    }

    /**
     * 条件查询菜单信息
     *
     * @param page
     * @param menuQueryParam
     * @return
     */
    @Override
    public IPage<MenuVo> getMenus(Page page, MenuPageParam menuQueryParam) {
        QueryWrapper<MenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(menuQueryParam.getName()), "name", menuQueryParam.getName());
        queryWrapper.eq("parent_id", menuQueryParam.getId() != null ? menuQueryParam.getId() : "0");
        queryWrapper.orderByAsc("order_num");
        IPage<MenuPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(MenuVo::new);
    }

    /**
     * 根据ids查看菜单信息
     *
     * @param list
     * @return
     */
    @Override
    public Set<MenuVo> getMenuByIds(List<Long> list) {
        if (list.size() == 0) {
            return Sets.newHashSet();
        }
        QueryWrapper<MenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", list);
        List<MenuPo> menuPos = this.baseMapper.selectList(queryWrapper);
        Set<MenuVo> menuVos = menuPos.stream().map(menuPo -> new MenuVo(menuPo)).collect(Collectors.toSet());
        return menuVos;
    }

    /**
     * 获取所有的菜单信息，树状结构
     *
     * @return
     */
    @Override
    public List<PermissionVo> getMenuTree() {
        //获取所有的菜单权限
        List<MenuPo> menuPos = this.list();
        List<HomeMenuVo> homeMenus = new ArrayList<>();
        menuPos.stream().forEach(menuPo -> {
            HomeMenuVo homeMenuVo = new HomeMenuVo();
            homeMenuVo.setParentId(menuPo.getParentId());
            homeMenuVo.setMenuId(menuPo.getId());
            homeMenuVo.setIcon(menuPo.getIcon());
            homeMenuVo.setMenuName(menuPo.getName());
            homeMenuVo.setPath(menuPo.getPath());
            homeMenus.add(homeMenuVo);
        });
        List<PermissionVo> result = homeMenus.stream()
                .filter(homeMenu -> homeMenu.getParentId().equals(0L))   //parentId为0 -> 父菜单
                .map(permission -> convert(permission, homeMenus)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<MenuVo> getSubMenus() {
        QueryWrapper<MenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("parent_id",0);
        List<MenuVo> menuVoList = this.list(queryWrapper).stream().map(menuPo -> new MenuVo(menuPo)).collect(Collectors.toList());
        return menuVoList;
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
