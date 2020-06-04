package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.BrandPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("品牌信息视图")
@NoArgsConstructor
public class BrandVo extends BaseVo<BrandPo> {


    public BrandVo(BrandPo brandPo) {
        BeanUtils.copyProperties(brandPo, this);
    }

}
