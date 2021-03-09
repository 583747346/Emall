package com.emall.emallumsentity.entity.form;

import com.emall.emallumsentity.entity.po.ResourcePo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("资源插入&更新表单")
public class ResourceForm extends BaseForm<ResourcePo> {

    @ApiModelProperty("资源code")
    private String code;
    @ApiModelProperty("资源类型")
    private String type;
    @ApiModelProperty("资源名称")
    private String name;
    @ApiModelProperty("资源地址")
    private String url;
    @ApiModelProperty("资源方法")
    private String method;
    @ApiModelProperty("资源描述")
    private String description;
    @ApiModelProperty("菜单id")
    private Long menuId;
}
