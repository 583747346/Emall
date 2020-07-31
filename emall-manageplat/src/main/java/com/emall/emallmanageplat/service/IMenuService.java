package com.emall.emallmanageplat.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.MenuQueryParam;
import com.emall.emallmanageplat.entity.po.MenuPo;
import com.emall.emallmanageplat.entity.vo.MenuVo;

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
     * @param menuPo
     * @return
     */
    Boolean insertMenu(MenuPo menuPo);

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    boolean deleteMenu(String menuId);

    /**
     * 更新菜单信息
     * @param menuPo
     * @return
     */
    boolean updateMenu(MenuPo menuPo);

    /**
     * 条件查询菜单列表
     * @param page
     * @param menuQueryParam
     * @return
     */
    IPage<MenuVo> getMenus(Page page, MenuQueryParam menuQueryParam);
}
