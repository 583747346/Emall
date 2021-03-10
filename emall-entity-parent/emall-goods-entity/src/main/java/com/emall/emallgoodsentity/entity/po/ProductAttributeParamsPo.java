package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("商品-参数值")
@TableName("product_attribute_params")
public class ProductAttributeParamsPo extends BasePo {

    private Long productId;

    private Long attributeId;

    private String attributeValue;

}
