package com.emall.emallappservice.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("会员实体")
@TableName("emall_member")
public class MemberPo extends BasePo {

    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
    @ApiModelProperty(value = "密码", name = "password")
    private String password;
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;
    @ApiModelProperty(value = "头像", name = "photo")
    private String photo;
    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;
    @ApiModelProperty(value = "昵称", name = "nick_name")
    private String nickName;
    @ApiModelProperty(value = "座右铭", name = "motto")
    private String motto;
    @ApiModelProperty(value = "最后登录时间", name = "login_time")
    private Date loginTime;
    @ApiModelProperty(value = "账户状态,0-启用,1-禁用", name = "status")
    private int status;
    @ApiModelProperty(value = "成长值", name = "growth_point")
    private int growthPoint;
    @ApiModelProperty(value = "会员等级描述", name = "name")
    private String name;
    @ApiModelProperty(value = "是否免运费,0-是,1-不是", name = "free_freight")
    private int freeFreight;
    @ApiModelProperty(value = "是否有签到权,0-是,1-不是", name = "sign_in")
    private int signIn;
    @ApiModelProperty(value = "积分", name = "point_score")
    private int pointScore;
    @ApiModelProperty(value = "微信id", name = "wechat_id")
    private int wechatId;

}
