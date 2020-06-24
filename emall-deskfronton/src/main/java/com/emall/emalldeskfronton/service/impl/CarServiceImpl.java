package com.emall.emalldeskfronton.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallcommon.web.entity.po.BasePo;
import com.emall.emalldeskfronton.entity.params.CarQueryParam;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;
import com.emall.emalldeskfronton.mapper.CarMapper;
import com.emall.emalldeskfronton.service.ICarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, EmallCarPo> implements ICarService {
    @Override
    public IPage<EmallCarVo> getCars(CarQueryParam orderQueryParam) {
        return null;
    }

    @Override
    public boolean insertCar(BasePo toPo) {
        return false;
    }
}
