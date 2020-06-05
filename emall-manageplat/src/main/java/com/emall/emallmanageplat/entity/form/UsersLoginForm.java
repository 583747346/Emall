package com.emall.emallmanageplat.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户登录表单")
public class UsersLoginForm implements Serializable {

    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

}
