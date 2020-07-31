package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("菜单查询—分页")
public class MenuQueryParam extends BaseQueryParam {

    @ApiModelProperty(value = "菜单名")
    private String name;

}
