package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.po.MenuPo;
import com.emall.emallweb.entity.vo.BaseVo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MenuVo extends BaseVo<MenuPo> {


    public MenuVo(MenuPo menuPo) {
        BeanUtils.copyProperties(menuPo, this);
    }


}
