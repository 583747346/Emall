package com.emall.emallweb.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品主题表")
public class ProductTopicPo extends BasePo {

    @ApiModelProperty(value = "主题描述")
    private String name;
    @ApiModelProperty(value = "主题图片")
    private String picture;
    @ApiModelProperty(value = "状态")
    private Integer status;

}
