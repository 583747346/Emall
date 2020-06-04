package com.emall.emallmanageplat.entity.po;

import java.io.Serializable;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallcommon.web.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("roles")
public class RolesPo extends BasePo implements Serializable {

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
     * 资源
     */
    @TableField(exist = false)
    private Set<String> resourceIds;

}
