package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("emall_product_attribute")
@ApiModel("商品属性信息")
public class ProductAttributePo extends BasePo {

    @ApiModelProperty(value = "属性名",name = "name")
    private String name;
    @ApiModelProperty(value = "属性列表",name = "attribute_list")
    private String attributeList;
    @ApiModelProperty(value = "属性类型(0-规格,1-参数)",name = "type")
    private Integer type;
    @ApiModelProperty(value = "属性状态(0-禁用,1-启用)",name = "status")
    private Integer status;
}
