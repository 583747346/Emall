package com.emall.emallgoodsentity.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("菜单树状视图")
@AllArgsConstructor
@NoArgsConstructor
public class HomeMenuVo {

    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("角色名")
    private String roleName;
    @ApiModelProperty("菜单id")
    private Long menuId;
    @ApiModelProperty("父级id")
    private Long parentId;
    @ApiModelProperty("菜单名")
    private String menuName;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("图标")
    private String icon;

}
