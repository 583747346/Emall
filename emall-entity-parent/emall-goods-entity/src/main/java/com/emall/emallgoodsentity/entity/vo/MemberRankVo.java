package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.MemberRankPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("会员等级视图")
public class MemberRankVo extends BaseVo {

    @ApiModelProperty(value = "会员等级")
    private String rank;

    @ApiModelProperty(value = "升级点")
    private Integer growthPoint;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remarks;

    public MemberRankVo(MemberRankPo memberRankPo) {
        BeanUtils.copyProperties(memberRankPo, this);
    }

}
