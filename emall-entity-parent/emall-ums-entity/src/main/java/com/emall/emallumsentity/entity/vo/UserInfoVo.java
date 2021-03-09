package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.UserPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@ApiModel("登录返回信息")
public class UserInfoVo extends BaseVo<UserPo> implements Serializable {

    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public UserInfoVo (UserPo userPo){
        BeanUtils.copyProperties(userPo,this);
    }
}
