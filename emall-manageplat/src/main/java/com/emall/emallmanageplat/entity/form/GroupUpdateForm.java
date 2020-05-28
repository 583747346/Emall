package com.emall.emallmanageplat.entity.form;

import com.emall.emallcommon.web.entity.BaseForm;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("用户组更新表单")
public class GroupUpdateForm extends BaseForm<GroupsPo> {
}
