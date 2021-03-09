package com.emall.emallappservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallappservice.entity.form.CarForm;
import com.emall.emallweb.entity.po.EmallCarPo;
import com.emall.emallappservice.entity.vo.EmallCarVo;
import com.emall.emallappservice.entity.vo.MemberVo;
import com.emall.emallappservice.mapper.CarMapper;
import com.emall.emallappservice.service.ICarService;
import com.emall.emallappservice.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, EmallCarPo> implements ICarService {

    @Autowired
    private IMemberService memberService;

    /**
     * 当前用户查看购物车信息
     *
     * @return
     */
    @Override
    public List<EmallCarVo> getCars() {
        //获取当前用户的信息
        MemberVo memberInfo = memberService.getMemberInfo();
        QueryWrapper<EmallCarPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", memberInfo.getId());
        List<EmallCarPo> emallCarPos = this.list(queryWrapper);
        return emallCarPos.stream().map(EmallCarVo::new).collect(Collectors.toList());
    }

    /**
     * 添加购物车
     *
     * @param carForm
     * @return
     */
    @Override
    @Transactional
    public boolean insertCar(CarForm carForm) {
        //获取当前会员信息
        MemberVo memberVo = memberService.getMemberInfo();
        EmallCarPo emallCarPo = carForm.toPo();
        emallCarPo.setMemberId(memberVo.getId());
        return this.save(emallCarPo);
    }

    /**
     * 根据购物车id——更新购物车单品数量
     *
     * @param id
     * @param productQty
     * @return
     */
    @Override
    @Transactional
    public boolean updateCar(String id, int productQty) {
        EmallCarPo emallCarPo = this.getById(id);
        emallCarPo.setQuantity(productQty);
        return this.updateById(emallCarPo);
    }

    /**
     * 根据购物车id——删除对应购物车数据（逻辑删除）
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteCar(String id) {
        EmallCarPo emallCarPo = this.getById(id);
        emallCarPo.setDeleteStatus(1);
        //添加到历史浏览记录
        return this.updateById(emallCarPo);
    }

    /**
     * 清空购物车
     *
     * @return
     */
    @Override
    @Transactional
    public boolean deleteAllCar() {
        //获取当前用户
        MemberVo memberInfo = memberService.getMemberInfo();
        QueryWrapper<EmallCarPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_id", memberInfo.getId());
        return this.remove(queryWrapper);
    }
}
