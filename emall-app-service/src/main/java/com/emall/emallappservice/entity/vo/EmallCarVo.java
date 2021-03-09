package com.emall.emallappservice.entity.vo;

import com.emall.emallweb.entity.vo.BaseProcessVo;
import com.emall.emallweb.entity.po.EmallCarPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("购物车数据视图")
public class EmallCarVo extends BaseProcessVo<EmallCarPo> {

    public EmallCarVo(EmallCarPo emallCarPo) {
        BeanUtils.copyProperties(emallCarPo, this);
    }

}
