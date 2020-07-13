package com.emall.emallmanageplat.entity.params;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductCommentPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品评论筛选查询-分页")
public class ProductCommentQueryParam extends BaseForm<ProductCommentPo> {

    @ApiModelProperty(value = "当前页—默认1")
    private long current = 1;
    @ApiModelProperty(value = "每页显示数—默认10")
    private long size = 10;
    @ApiModelProperty(value = "商品名")
    private String productName;

    public Page getPage() {
        return new Page(this.getCurrent(), this.getSize());
    }
}
