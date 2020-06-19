package com.emall.emalldeskfronton.web;

import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.params.OrderQueryParam;
import com.emall.emallmanageplat.entity.vo.ProductCommentVo;
import com.emall.emallmanageplat.service.ICarService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "EmallCarController", value = "购物车信息-API")
@RequestMapping("/car")
public class EmallCarController {

    @Autowired
    private ICarService carService;

    @ApiOperation(value = "获取购物车信息", notes = "获取购物车信息")
    @ApiImplicitParam(name = "OrderQueryParam", value = "订单筛选参数", required = true, dataType = "OrderQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductCommentVo> getAttribute(@RequestBody OrderQueryParam orderQueryParam) {
        return Result.success(orderService.getOrders(orderQueryParam));
    }

}
