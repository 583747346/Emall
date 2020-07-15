package com.emall.emalldeskfronton.entity.vo;

import com.emall.emalldeskfronton.entity.po.MemberPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
@ApiModel("会员信息返回视图")
public class MemberVo extends BaseVo {

    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "手机号")
    private String tel;
    @ApiModelProperty(value = "头像")
    private String photo;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "座右铭")
    private String motto;
    @ApiModelProperty(value = "成长值")
    private int growthPoint;
    @ApiModelProperty(value = "会员等级描述")
    private String name;
    @ApiModelProperty(value = "是否免运费,0-是,1-不是")
    private int freeFreight;
    @ApiModelProperty(value = "是否有签到权,0-是,1-不是")
    private int signIn;
    @ApiModelProperty(value = "积分")
    private int pointScore;
    @ApiModelProperty(value = "微信id")
    private int wechatId;

    public MemberVo(MemberPo memberPo) {
        BeanUtils.copyProperties(memberPo, this);
    }

}
