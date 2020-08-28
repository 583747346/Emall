package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.po.ProductSkuPo;
import com.emall.emallweb.entity.po.ProductsPo;
import com.emall.emallweb.entity.vo.BaseVo;
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
