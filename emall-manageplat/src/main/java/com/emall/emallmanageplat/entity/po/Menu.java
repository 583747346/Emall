package com.emall.emallmanageplat.entity.po;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
public class Menu {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单id
     */
    @ApiModelProperty(value = "父菜单id",name = "parent_id")
    private String parentId;

    /**
     * 菜单类型
     */
    @ApiModelProperty(value = "菜单类型",name = "type")
    private String type;

    /**
     * 菜单路径
     */
    @ApiModelProperty(value = "菜单路径",name = "href")
    private String href;

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

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间",name = "updated_time")
    private Date updatedTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",name = "created_by")
    private String createdBy;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人",name = "updated_by")
    private String updatedBy;

}
