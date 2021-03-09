package com.emall.emallumsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

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
@TableName("menu")
public class MenuPo extends BasePo implements Serializable {
    /**
     * 父菜单id
     */
    @Id
    @ApiModelProperty(value = "父菜单id",name = "parent_id")
    private Long parentId;

    /**
     * 菜单类型
     */
    @ApiModelProperty(value = "菜单类型",name = "type")
    private String type;

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

}
