package com.emall.emallgoodsentity.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("品类-属性实体类")
@TableName("category_attribute_relation")
public class CategoryAttributePo extends BasePo {

    private Long productCategoryId;

    private Long productAttributeId;

}
