package com.emall.emallmanageplat.entity.form;

import com.emall.emallcommon.web.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("产品插入&更新表单")
public class ProductForm extends BaseForm<ProductsPo> {



}
