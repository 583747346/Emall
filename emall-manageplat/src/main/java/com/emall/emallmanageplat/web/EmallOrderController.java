package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.params.OrderQueryParam;
import com.emall.emallmanageplat.entity.vo.ProductCommentVo;
import com.emall.emallmanageplat.service.IOrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "EmallOrderController",value = "订单信息-API")
@RequestMapping("/order")
public class EmallOrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "获取订单信息", notes = "条件获取订单信息")
    @ApiImplicitParam(name = "OrderQueryParam", value = "订单筛选参数", required = true, dataType = "OrderQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductCommentVo> getAttribute(@RequestBody OrderQueryParam orderQueryParam) {
        return Result.success(orderService.getOrders(orderQueryParam));
    }


    @ApiOperation(value = "获取订单详情", notes = "根据订单id获取订单信息")
    @ApiImplicitParam(name = "id",value = "订单id", required = true, dataType = "String")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/{oid}")
    public Result<ProductCommentVo> getAttribute(@PathVariable String oid) {
        return Result.success(orderService.getOrdersById(oid));
    }

}
