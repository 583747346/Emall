package com.emall.emalldeskfronton.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emalldeskfronton.entity.form.CarForm;
import com.emall.emalldeskfronton.entity.params.CarQueryParam;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;

public interface ICarService {

    IPage<EmallCarVo> getCars(CarQueryParam orderQueryParam);

    boolean insertCar(CarForm toPo);

    boolean updateCar(String id, int productQty);

    boolean deleteCar(String id);
}
