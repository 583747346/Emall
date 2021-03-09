package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("产品信息视图")
@NoArgsConstructor
public class ProductVo extends BaseVo<ProductPo> {

    public ProductVo(ProductPo productPo){
        BeanUtils.copyProperties(productPo,this);
    }

}
