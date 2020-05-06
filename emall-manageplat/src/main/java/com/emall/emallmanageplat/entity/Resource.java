package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
public class Resource{

    private static final long serialVersionUID = 1L;

    /**
     * 资源code
     */
    private String code;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源url
     */
    private String url;

    /**
     * 资源方法
     */
    private String method;

    /**
     * 简介
     */
    private String description;

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
