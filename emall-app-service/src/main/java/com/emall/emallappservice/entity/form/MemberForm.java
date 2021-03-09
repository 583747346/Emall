package com.emall.emallappservice.entity.form;

import com.emall.emallappservice.entity.po.MemberPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("会员注册表单")
public class MemberForm extends BaseForm<MemberPo> {

    @ApiModelProperty(value = "手机号")
    private String tel;
    @ApiModelProperty(value = "验证码")
    private String valid;
}
