package com.emall.emallgoodsentity.entity.vo;


import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallgoodsentity.entity.po.ProductSkuPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品sku视图")
public class ProductSkuVo extends BaseVo<ProductPo> {

    public ProductSkuVo(ProductSkuPo productSkuPo) {
        BeanUtils.copyProperties(productSkuPo, this);
    }

}
