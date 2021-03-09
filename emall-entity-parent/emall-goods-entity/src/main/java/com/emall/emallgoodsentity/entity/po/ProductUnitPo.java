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
 * 商品单位
 * </p>
 *
 * @author qinlang
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("product_unit")
@ApiModel(value="ProductUnitPo对象", description="商品单位")
public class ProductUnitPo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
