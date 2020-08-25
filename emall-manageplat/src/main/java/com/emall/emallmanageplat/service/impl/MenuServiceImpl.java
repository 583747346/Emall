package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.form.MenuForm;
import com.emall.emallmanageplat.entity.params.MenuQueryParam;
import com.emall.emallmanageplat.entity.po.MenuPo;
import com.emall.emallmanageplat.entity.vo.MenuVo;
import com.emall.emallmanageplat.mapper.MenuMapper;
import com.emall.emallmanageplat.oss.OssUploadPicture;
import com.emall.emallmanageplat.service.IMenuService;
import com.emall.emallmanageplat.tool.OssBucketEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
        MenuPo menuPo = menuForm.toPo(menuId,MenuPo.class);
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
    public IPage<MenuVo> getMenus(Page page, MenuQueryParam menuQueryParam) {
        QueryWrapper<MenuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(menuQueryParam.getUsername()), "name", menuQueryParam.getUsername());
        IPage<MenuPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(MenuVo::new);
    }
}
