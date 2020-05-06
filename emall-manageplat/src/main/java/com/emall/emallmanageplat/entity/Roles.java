package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
public class Roles{

    private static final long serialVersionUID = 1L;

    /**
     * 角色code
     */
    @ApiModelProperty(value = "角色code",name = "code")
    private String code;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称",name = "name")
    private String name;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介",name = "description")
    private String description;

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
