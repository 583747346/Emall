package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品主题表")
@TableName("product_topic")
public class ProductTopicPo extends BasePo {

    @ApiModelProperty(value = "主题描述")
    private String name;
    @ApiModelProperty(value = "主题图片")
    private String picture;
    @ApiModelProperty(value = "状态")
    private Integer status;

}
