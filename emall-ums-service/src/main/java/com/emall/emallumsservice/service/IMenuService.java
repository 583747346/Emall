package com.emall.emallumsservice.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallumsentity.entity.form.MenuForm;
import com.emall.emallumsentity.entity.params.MenuPageParam;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.PermissionVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IMenuService {

    /**
     * 添加菜单信息
     * @param menuForm
     * @return
     */
    Boolean insertMenu(MenuForm menuForm);

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    boolean deleteMenu(Long menuId);

    /**
     * 更新菜单信息
     * @param menuId
     * @param menuForm
     * @return
     */
    boolean updateMenu(Long menuId, MenuForm menuForm);

    /**
     * 条件查询菜单列表
     * @param page
     * @param menuQueryParam
     * @return
     */
    IPage<MenuVo> getMenus(Page page, MenuPageParam menuQueryParam);

    /**
     * 根据ids集合查看菜单信息
     * @param list
     * @return
     */
    Set<MenuVo> getMenuByIds(List<Long> list);

    List<PermissionVo> getMenuTree();

    List<MenuVo> getSubMenus();
}
