package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.params.ProductCommentQueryParam;
import com.emall.emallmanageplat.entity.vo.ProductCommentVo;
import com.emall.emallmanageplat.service.IProductCommontService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@Api(value = "ProductCommentController", tags = "商品评论API")
public class ProductCommentController {

    @Autowired
    private IProductCommontService productCommontService;

    @ApiOperation(value = "获取商品评论信息", notes = "根据商品名获取商品评论信息")
    @ApiImplicitParam(name = "ProductCommentQueryParam", value = "商品评论参数", required = true, dataType = "ProductCommentQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductCommentVo> getAttribute(@RequestBody ProductCommentQueryParam param) {
        return Result.success(productCommontService.getComments(param));
    }
}
