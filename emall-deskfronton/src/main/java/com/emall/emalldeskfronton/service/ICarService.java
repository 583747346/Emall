package com.emall.emalldeskfronton.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcommon.web.entity.po.BasePo;
import com.emall.emalldeskfronton.entity.params.CarQueryParam;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;

public interface ICarService {

    IPage<EmallCarVo> getCars(CarQueryParam orderQueryParam);

    boolean insertCar(BasePo toPo);
}
