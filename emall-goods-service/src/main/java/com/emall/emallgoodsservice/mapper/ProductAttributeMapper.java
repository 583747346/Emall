package com.emall.emallgoodsservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeValueVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductAttributeMapper extends BaseMapper<ProductAttributePo> {
    @Select("select ${ew.sqlSelect} from product_category epc " +
            "INNER JOIN category_attribute_relation ecar ON epc.id = ecar.product_category_id " +
            "INNER JOIN product_attribute epa ON ecar.product_attribute_id = epa.id ${ew.customSqlSegment}")
    IPage<ProductAttributeValueVo> getCategoryAttribute(Page page, @Param(Constants.WRAPPER) QueryWrapper<ProductAttributeValueVo> queryWrapper);

    @Select("select ${ew.sqlSelect} from product_attribute epa left join category_attribute_relation ecar ON ecar.product_attribute_id = epa.id ${ew.customSqlSegment}")
    List<ProductAttributePo> attributeByCategoryId(@Param(Constants.WRAPPER) QueryWrapper<ProductAttributePo> queryWrapper);
}
