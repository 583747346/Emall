package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallweb.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户组筛选条件-分页")
public class GroupQueryParam extends BaseQueryParam<GroupParam> implements Serializable {

    @ApiModelProperty(value = "查询开始时间")
    private String name;

}
