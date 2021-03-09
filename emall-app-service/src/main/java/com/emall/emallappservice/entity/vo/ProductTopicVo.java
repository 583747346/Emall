package com.emall.emallappservice.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductTopicPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品主题")
public class ProductTopicVo {


    public ProductTopicVo(ProductTopicPo productTopicPo){
        BeanUtils.copyProperties(productTopicPo,this);
    }

}
