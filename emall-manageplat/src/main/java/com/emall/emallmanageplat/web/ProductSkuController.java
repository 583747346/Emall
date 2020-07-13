package com.emall.emallmanageplat.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.ProductSkuForm;
import com.emall.emallmanageplat.entity.params.ProductSkuParam;
import com.emall.emallmanageplat.entity.params.ProductSkuQueryParam;
import com.emall.emallmanageplat.entity.vo.ProductSkuVo;
import com.emall.emallmanageplat.service.IProductSkuService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productSku")
@Api(tags = "ProductSkuController", value = "商品sku-API")
public class ProductSkuController {

    @Autowired
    private IProductSkuService productSkuService;

    @ApiOperation(value = "查询商品sku信息", tags = "根据商品名获取商品sku信息")
    @ApiImplicitParam(paramType = "ProductSkuParam", value = "sku查询参数", required = true, dataType = "ProductSkuParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<IPage<ProductSkuVo>> getProductSku(@RequestBody ProductSkuQueryParam skuQueryParam) {
        return Result.success(productSkuService.getProductSku(skuQueryParam.getPage(), skuQueryParam.toParam(ProductSkuParam.class)));
    }

    @ApiOperation(value = "批量更新库存信息", tags = "根据商品id批量更新库存信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", value = "商品id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "ProductSkuForm", value = "商品sku表单", required = true, dataType = "ProductSkuForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{pid}")
    @ResponseBody
    public Result update(@PathVariable String pid, @RequestBody List<ProductSkuForm> skuStockList) {
        return Result.success(productSkuService.updateByPid(pid, skuStockList));

    }

}
