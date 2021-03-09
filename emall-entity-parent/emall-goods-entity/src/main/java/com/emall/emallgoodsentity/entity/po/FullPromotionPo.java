package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 满减促销表
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("full_promotion")
@ApiModel(value="FullPromotionPo对象", description="满减促销表")
public class FullPromotionPo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品编号")
    private Long productId;

    @ApiModelProperty(value = "商品满价（需要满足的金额）")
    private BigDecimal fullPrice;

    @ApiModelProperty(value = "商品减价（满减金额）")
    private BigDecimal reducePrice;


}
