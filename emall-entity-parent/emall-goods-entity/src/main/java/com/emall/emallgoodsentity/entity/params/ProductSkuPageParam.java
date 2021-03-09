package com.emall.emallgoodsentity.entity.params;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品sku筛选条件-分页")
public class ProductSkuPageParam extends BasePageParam<ProductSkuParam> {

    private long current = 1;

    private long size = 10;

    public Page getPage() {
        return new Page(this.getCurrent(), this.getSize());
    }

    @ApiModelProperty(value = "商品id")
    private String productId;

}
