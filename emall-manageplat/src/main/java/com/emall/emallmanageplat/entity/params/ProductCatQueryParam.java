package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallcommon.web.entity.params.BaseQueryParam;
import com.emall.emallmanageplat.entity.po.ProductCategoryPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类筛选参数-分页")
public class ProductCatQueryParam extends BaseQueryParam<ProductCatParam> {

    @ApiModelProperty(value = "商品分类名")
    private String name;

}
