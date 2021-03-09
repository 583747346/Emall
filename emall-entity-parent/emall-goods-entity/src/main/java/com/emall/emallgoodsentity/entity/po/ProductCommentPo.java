package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("emall_product_comment")
@ApiModel("商品评论实体")
public class ProductCommentPo extends BasePo {
}
