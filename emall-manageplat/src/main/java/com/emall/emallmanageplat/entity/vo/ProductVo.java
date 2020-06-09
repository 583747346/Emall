package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("产品信息视图")
@NoArgsConstructor
public class ProductVo extends BaseVo<ProductsPo> {

    public void toVo(ProductsPo productsPo){
        BeanUtils.copyProperties(productsPo,this);
    }
    public ProductVo(ProductsPo productsPo){
        BeanUtils.copyProperties(productsPo,this);
    }

}