package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("会员查询参数")
public class MemberQueryParam extends BaseQueryParam {

    @ApiModelProperty(value = "会员等级描述",name = "level_name")
    private String levelName;

}
