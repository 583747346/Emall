package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("用户组插入&更新表单")
public class GroupForm extends BaseForm<GroupsPo> {

    @NotBlank(message = "用户组父id不能为空")
    @ApiModelProperty(value = "用户组父id")
    private String parentId;

    @NotBlank(message = "用户组名称不能为空")
    @ApiModelProperty(value = "用户组名称")
    private String name;

    @ApiModelProperty(value = "用户组描述")
    private String description;

    @ApiModelProperty(value = "逻辑删除(N-不删除，Y-删除)")
    private String deleted;

}
