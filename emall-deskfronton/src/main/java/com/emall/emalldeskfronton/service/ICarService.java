package com.emall.emalldeskfronton.service;

import com.emall.emalldeskfronton.entity.form.CarForm;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;

import java.util.List;

public interface ICarService {

    List<EmallCarVo> getCars();

    boolean insertCar(CarForm toPo);

    boolean updateCar(String id, int productQty);

    boolean deleteCar(String id);

    boolean deleteAllCar();
}
