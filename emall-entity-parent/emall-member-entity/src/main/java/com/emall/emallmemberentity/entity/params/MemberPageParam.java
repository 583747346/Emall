package com.emall.emallmemberentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("会员查询参数")
public class MemberPageParam extends BasePageParam {

    @ApiModelProperty(value = "会员等级描述",name = "level_name")
    private String levelName;
    @ApiModelProperty(value = "会员状态",name = "level_name")
    private Integer status;

}
