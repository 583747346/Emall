package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.ProductSkuPo;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品sku视图")
public class ProductSkuVo extends BaseVo<ProductsPo> {

    public ProductSkuVo(ProductSkuPo productSkuPo) {
        BeanUtils.copyProperties(productSkuPo, this);
    }

}
