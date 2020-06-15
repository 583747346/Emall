package com.emall.emallmanageplat.entity.params;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallcommon.web.entity.params.BaseQueryParam;
import com.emall.emallmanageplat.entity.po.ProductSkuPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品sku筛选条件-分页")
public class ProductSkuQueryParam extends BaseQueryParam<ProductSkuParam> {

    private long current = 1;

    private long size = 10;

    public Page getPage() {
        return new Page(this.getCurrent(), this.getSize());
    }

    @ApiModelProperty(value = "商品id")
    private String productId;

}
