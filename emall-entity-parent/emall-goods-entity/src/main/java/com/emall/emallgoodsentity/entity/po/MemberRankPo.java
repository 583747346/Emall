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
 * 会员等级
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("member_rank")
@ApiModel(value = "MemberRankPo对象", description = "会员等级")
public class MemberRankPo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员等级")
    private String rank;

    @ApiModelProperty(value = "升级点")
    private Integer growthPoint;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
