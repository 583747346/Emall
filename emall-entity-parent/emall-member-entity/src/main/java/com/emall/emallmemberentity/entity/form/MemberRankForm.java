package com.emall.emallmemberentity.entity.form;

import com.emall.emallmemberentity.entity.po.MemberRankPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("会员等级表单")
public class MemberRankForm extends BaseForm<MemberRankPo> {
}
