package com.emall.emalldeskfronton.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcommon.core.result.Result;
import com.emall.emalldeskfronton.entity.form.CarForm;
import com.emall.emalldeskfronton.entity.params.CarQueryParam;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;
import com.emall.emalldeskfronton.service.ICarService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "EmallCarController", value = "购物车信息-API")
@RequestMapping("/car")
public class EmallCarController {

    @Autowired
    private ICarService carService;

    @ApiOperation(value = "获取会员购物车信息", notes = "获取会员购物车信息")
    @ApiImplicitParam(name = "CarQueryParam", value = "购物车筛选参数", required = true, dataType = "CarQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<IPage<EmallCarVo>> getAttribute(@RequestBody CarQueryParam orderQueryParam) {
        return Result.success(carService.getCars(orderQueryParam));
    }

    @ApiOperation(value = "添加商品到购物车", notes = "会员添加商品到购物车")
    @PostMapping
    @ApiImplicitParam(paramType = "CarForm", value = "添加产品表单", required = true, dataType = "CarForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertProduct(@RequestBody CarForm catForm) {
        return Result.success(carService.insertCar(catForm.toPo(EmallCarPo.class)));
    }

}
