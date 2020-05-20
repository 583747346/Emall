package com.emall.emallmanageplat.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户表单")
public class UsersForm implements Serializable {

    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String validcode;

}
