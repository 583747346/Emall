package com.emall.emallappservice.service;

import com.emall.emallappservice.entity.form.CarForm;
import com.emall.emallappservice.entity.vo.EmallCarVo;

import java.util.List;

public interface ICarService {

    List<EmallCarVo> getCars();

    boolean insertCar(CarForm toPo);

    boolean updateCar(String id, int productQty);

    boolean deleteCar(String id);

    boolean deleteAllCar();
}
