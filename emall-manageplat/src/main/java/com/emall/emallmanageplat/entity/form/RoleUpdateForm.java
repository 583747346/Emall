package com.emall.emallmanageplat.entity.form;

import com.emall.emallcommon.web.entity.BaseForm;
import com.emall.emallmanageplat.entity.po.RolesPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

@Data
@ApiModel("角色信息表单")
public class RoleUpdateForm extends BaseForm<RolesPo> {

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "角色拥有的资源id列表")
    private Set<String> resourceIds;

}
