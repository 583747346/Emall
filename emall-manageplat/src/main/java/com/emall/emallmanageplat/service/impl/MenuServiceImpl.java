package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.MenuQueryParam;
import com.emall.emallmanageplat.entity.po.MenuPo;
import com.emall.emallmanageplat.entity.vo.MenuVo;
import com.emall.emallmanageplat.mapper.MenuMapper;
import com.emall.emallmanageplat.service.IMenuService;
import com.emall.emallweb.entity.po.BasePo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 新添菜单信息
     * @param menuPo
     * @return
     */
    @Override
    @Transactional
    public Boolean insertMenu(MenuPo menuPo) {
        return this.save(menuPo);
    }

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteMenu(String menuId) {
        return this.removeById(menuId);
    }

    /**
     * 更新菜单信息
     * @param menuPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateMenu(MenuPo menuPo) {
        return this.updateById(menuPo);
    }

    /**
     * 条件查询菜单信息
     * @param page
     * @param menuQueryParam
     * @return
     */
    @Override
    public IPage<MenuVo> getMenus(Page page, MenuQueryParam menuQueryParam) {
        QueryWrapper<MenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(menuQueryParam.getUsername()), "name", menuQueryParam.getUsername());
        IPage<MenuPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(MenuVo::new);
    }
}
