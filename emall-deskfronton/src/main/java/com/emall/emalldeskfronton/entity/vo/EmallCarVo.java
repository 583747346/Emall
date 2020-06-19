package com.emall.emalldeskfronton.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseProcessVo;
import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("购物车数据视图")
public class EmallCarVo extends BaseProcessVo<EmallCarPo> {
}
