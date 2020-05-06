package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
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
    @TableField("parent_id")
    private String parentId;

    /**
     * 菜单类型
     */
    private String type;

    /**
     * 菜单路径
     */
    private String href;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

}
