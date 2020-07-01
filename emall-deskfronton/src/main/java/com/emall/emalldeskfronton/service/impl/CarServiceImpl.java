package com.emall.emalldeskfronton.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emalldeskfronton.entity.form.CarForm;
import com.emall.emalldeskfronton.entity.params.CarQueryParam;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import com.emall.emalldeskfronton.entity.po.MemberPo;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;
import com.emall.emalldeskfronton.mapper.CarMapper;
import com.emall.emalldeskfronton.service.ICarService;
import com.emall.emalldeskfronton.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, EmallCarPo> implements ICarService {

    @Autowired
    private IMemberService memberService;

    @Override
    public IPage<EmallCarVo> getCars(CarQueryParam orderQueryParam) {
        return null;
    }

    /**
     * 添加购物车
     *
     * @param carForm
     * @return
     */
    @Override
    public boolean insertCar(CarForm carForm) {
        //根据userid获取会员信息
        MemberPo memberPo = memberService.getCurrentUser();
        EmallCarPo emallCarPo = carForm.toPo();
        emallCarPo.setMemberId(memberPo.getId());
        return this.save(emallCarPo);
    }

    /**
     * 根据购物车id——更新购物车单品数量
     * @param id
     * @param productQty
     * @return
     */
    @Override
    public boolean updateCar(String id, int productQty) {
        EmallCarPo emallCarPo = this.getById(id);
        emallCarPo.setQuantity(productQty);
        return this.updateById(emallCarPo);
    }

    /**
     * 根据购物车id——删除对应购物车数据（逻辑删除）
     * @param id
     * @return
     */
    @Override
    public boolean deleteCar(String id) {
        EmallCarPo emallCarPo = this.getById(id);
        emallCarPo.setDeleteStatus(1);
        return this.updateById(emallCarPo);
    }
}
