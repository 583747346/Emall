package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.UsersPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@ApiModel("登录返回信息")
public class UserInfoVo extends BaseVo<UsersPo> implements Serializable {

    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public UserInfoVo (UsersPo usersPo){
        BeanUtils.copyProperties(usersPo,this);
    }
}
