package com.emall.emallumsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户组筛选条件-分页")
public class GroupPageParam extends BasePageParam<GroupParam> implements Serializable {

    @ApiModelProperty(value = "查询开始时间")
    private String name;

}
