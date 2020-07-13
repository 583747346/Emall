package com.emall.emallmanageplat.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("resource")
public class ResourcePo extends BasePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源code
     */
    @ApiModelProperty(value = "资源code",name = "code")
    private String code;

    /**
     * 资源类型
     */
    @ApiModelProperty(value = "资源类型",name = "type")
    private String type;

    /**
     * 资源名称
     */
    @ApiModelProperty(value = "资源名称",name = "name")
    private String name;

    /**
     * 资源url
     */
    @ApiModelProperty(value = "资源url",name = "url")
    private String url;

    /**
     * 资源方法
     */
    @ApiModelProperty(value = "资源方法",name = "method")
    private String method;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介",name = "description")
    private String description;

}
