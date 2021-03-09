package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.MemberPricePo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@ApiModel("会员价格视图")
public class MemberPriceVo extends BaseVo {

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "会员等级id")
    private Long rankId;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    public MemberPriceVo(MemberPricePo memberPricePo) {
        BeanUtils.copyProperties(memberPricePo, this);
    }
}
