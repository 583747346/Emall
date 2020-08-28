package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallweb.entity.po.ProductCommentPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
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
