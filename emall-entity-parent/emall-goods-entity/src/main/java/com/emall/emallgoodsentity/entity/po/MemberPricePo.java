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
 * 会员价格
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("member_price")
@ApiModel(value="MemberPricePo对象", description="会员价格")
public class MemberPricePo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "会员等级id")
    private Long rankId;

    @ApiModelProperty(value = "会员等级描述")
    private String memberLevelName;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;


}
