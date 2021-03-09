package com.emall.emallumsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("角色分页请求参数")
public class RolePageParam extends BasePageParam {

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称",name = "name")
    private String name;

}
