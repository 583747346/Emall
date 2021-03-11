package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品属性规格值
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("product_attribute_value")
@ApiModel(value="ProductAttributeValuePo对象", description="商品属性规格值")
public class ProductAttributeValuePo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品属性id")
    private Long attributeId;

    @ApiModelProperty(value = "属性规格值")
    private String atrributeValue;

    @ApiModelProperty(value = "规格code")
    private String specsCode;

}
