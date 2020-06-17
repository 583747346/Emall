package com.emall.emalldeskfronton.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import com.emall.emalldeskfronton.mapper.CarMapper;
import com.emall.emalldeskfronton.service.ICarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, EmallCarPo> implements ICarService {
}
