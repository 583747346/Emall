package com.emall.emallgoodsentity.entity.params;

import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallweb.entity.params.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类筛选参数")
public class ProductCatParam extends BaseParam<ProductCategoryPo> {

    @ApiModelProperty(value = "商品分类名")
    private String name;
    @ApiModelProperty(value = "商品父id")
    private Long parentId;
}
