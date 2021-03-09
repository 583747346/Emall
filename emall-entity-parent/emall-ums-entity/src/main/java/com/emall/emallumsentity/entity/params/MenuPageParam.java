package com.emall.emallumsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("菜单查询—分页")
public class MenuPageParam extends BasePageParam {

    @ApiModelProperty(value = "菜单名")
    private String name;
    @ApiModelProperty(value = "id")
    private Long id;

}
