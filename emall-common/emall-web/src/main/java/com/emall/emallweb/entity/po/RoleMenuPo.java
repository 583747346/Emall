package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_menu_relation")
@ApiModel("角色-菜单表")
public class RoleMenuPo extends BasePo {

    @ApiModelProperty(value = "角色id")
    private Long roleId;
    @ApiModelProperty(value = "菜单id")
    private Long menuId;

}
