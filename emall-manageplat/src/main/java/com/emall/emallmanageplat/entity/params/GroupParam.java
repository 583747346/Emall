package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupParam extends BaseParam<GroupsPo> {

    @ApiModelProperty(value = "查询开始时间")
    private String name;

}
