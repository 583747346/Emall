package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("产品信息视图")
public class ProductVo extends BaseVo<ProductsPo> {

    public void toVo(ProductsPo productsPo){
        BeanUtils.copyProperties(productsPo,this);
    }

}
