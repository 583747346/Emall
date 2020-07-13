package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("emall_product_attribute")
@ApiModel("商品属性信息")
public class ProductAttributePo extends BasePo {

    @ApiModelProperty(value = "商品id",name = "product_id")
    private String productId;
    @ApiModelProperty(value = "商品属性分类id",name = "product_category_id")
    private String productCategoryId;
    @ApiModelProperty(value = "属性描述",name = "name")
    private String name;
    @ApiModelProperty(value = "属性排序",name = "sort")
    private int sort;

}
