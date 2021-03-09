package com.emall.emallgoodsentity.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("用户菜单权限信息视图")
public class PermissionVo extends HomeMenuVo{
    @ApiModelProperty("子级菜单")
    private List<PermissionVo> children;
}
