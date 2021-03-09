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
 * 商品属性参数值
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("product_attribute_value")
@ApiModel(value="ProductAttributeValuePo对象", description="商品属性参数值")
public class PmsProductAttributeValuePo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "商品属性参数id")
    private Long atrributeParamsId;

    @ApiModelProperty(value = "属性参数")
    private String atrributeParams;


}
