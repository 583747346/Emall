package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.MenuPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("菜单视图")
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo extends BaseVo<MenuPo> {
    /**
     * 菜单类型
     */
    @ApiModelProperty(value = "菜单类型",name = "type")
    private String type;

    /**
     * 菜单类型
     */
    @ApiModelProperty(value = "父菜单id",name = "parent_id")
    private Long parentId;

    /**
     * 菜单路径
     */
    @ApiModelProperty(value = "菜单路径",name = "path")
    private String path;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标",name = "icon")
    private String icon;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称",name = "name")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述",name = "description")
    private String description;

    /**
     * 订单
     */
    @ApiModelProperty(value = "排序",name = "order_num")
    private Integer orderNum;

    public MenuVo(MenuPo menuPo) {
        BeanUtils.copyProperties(menuPo, this);
    }


}
