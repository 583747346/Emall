package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
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
    @TableField("parent_id")
    private String parentId;

    /**
     * 用户组名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否已删除Y：已删除，N：未删除
     */
    private String deleted;

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
