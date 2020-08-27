package com.emall.emalldeskfronton.web;

import com.emall.emallcore.result.Result;
import com.emall.emalldeskfronton.entity.vo.EmallCarVo;
import com.emall.emalldeskfronton.service.IAdvertiseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
@Api(tags = "emall首页", value = "IndexController")
public class IndexController {

    @Autowired
    private IAdvertiseService advertiseService;

    @ApiOperation(value = "顶部轮播广告", notes = "顶部轮播广告")
    @ApiImplicitParam(name = "CarQueryParam", value = "购物车筛选参数", required = true, dataType = "CarQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<List<EmallCarVo>> getAdvertisePics() {
        return Result.success(advertiseService.getAdvertisePics());
    }


}
