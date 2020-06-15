package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.ProductCommentPo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品评论视图")
public class ProductCommentVo extends BaseVo<ProductCommentPo> {


    /**
     * Po ->Vo
     * @param po
     */
    public ProductCommentVo(ProductCommentPo po){
        BeanUtils.copyProperties(po,this);
    }

}
