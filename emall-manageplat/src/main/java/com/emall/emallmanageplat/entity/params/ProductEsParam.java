package com.emall.emallmanageplat.entity.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ES模糊查询参数
 */
@Data
@ApiModel("产品模糊查询参数信息")
public class ProductEsParam implements Serializable {

    @ApiModelProperty(value = "关键字")
    private String key;
    @ApiModelProperty(value = "当前页")
    private int current;
    @ApiModelProperty(value = "页尺寸")
    private int size;

}
