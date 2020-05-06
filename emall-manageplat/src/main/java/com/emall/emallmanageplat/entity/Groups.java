package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户组表
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
public class Groups {

    private static final long serialVersionUID = 1L;

    /**
     * 用户组父id
     */
    @ApiModelProperty(value = "用户组父id",name = "parent_id")
    private String parentId;

    /**
     * 用户组名称
     */
    @ApiModelProperty(value = "用户组名称",name = "name")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述",name = "description")
    private String description;

    /**
     * 是否已删除Y：已删除，N：未删除
     */
    @ApiModelProperty(value = "删除标记",name = "deleted")
    private String deleted;

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
