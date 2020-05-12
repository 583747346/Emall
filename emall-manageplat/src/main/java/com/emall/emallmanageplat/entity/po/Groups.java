package com.emall.emallmanageplat.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.emall.emallcommon.web.entity.BasePo;
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
public class Groups extends BasePo implements Serializable {

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

}
