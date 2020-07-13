package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.RolesPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@ApiModel("添加角色信息表单")
public class RoleInsertForm extends BaseForm<RolesPo> {

    @NotBlank(message = "角色编码不能为空")
    @ApiModelProperty(value = "角色编码")
    private String code;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "角色拥有的资源id列表")
    private Set<String> resourceIds;

}
