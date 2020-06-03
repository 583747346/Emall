package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("产品关键字查询参数-分页")
public class ProductQueryParam extends BaseQueryParam<ProductParam> {

    @ApiModelProperty(value = "产品名")
    private String name;
    @ApiModelProperty(value = "产品类别")
    private String productCategory;
    @ApiModelProperty(value = "品牌")
    private String brand;

}
