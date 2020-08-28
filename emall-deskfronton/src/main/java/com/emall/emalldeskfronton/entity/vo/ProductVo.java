package com.emall.emalldeskfronton.entity.vo;

import com.emall.emallweb.entity.po.ProductsPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("产品信息视图")
@NoArgsConstructor
public class ProductVo extends BaseVo<ProductsPo> {

    public ProductVo(ProductsPo productsPo){
        BeanUtils.copyProperties(productsPo,this);
    }

}
