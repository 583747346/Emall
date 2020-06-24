package com.emall.emalldeskfronton.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emalldeskfronton.entity.param.CarQueryParam;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;

public interface ICarService {

    IPage<EmallCarVo> getCars(CarQueryParam orderQueryParam);
}
