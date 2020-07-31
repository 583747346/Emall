package com.emall.emallmanageplat.entity.form;

import com.emall.emallmanageplat.entity.po.MenuPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuForm extends BaseForm<MenuPo> {

    /**
     * 父菜单id
     */
    @ApiModelProperty(value = "父菜单id")
    @NotBlank(message = "菜单父id不能为空")
    private String parentId;

    /**
     * 菜单类型
     */
    @ApiModelProperty(value = "菜单类型")
    @NotBlank(message = "菜单类型不能为空")
    private String type;

    /**
     * 菜单路径
     */
    @ApiModelProperty(value = "菜单路径")
    @NotBlank(message = "菜单路径不能为空")
    private String href;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 订单
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;

}
