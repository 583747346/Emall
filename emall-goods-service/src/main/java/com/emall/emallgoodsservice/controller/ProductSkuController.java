package com.emall.emallgoodsservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallgoodsentity.entity.params.ProductSkuPageParam;
import com.emall.emallgoodsentity.entity.params.ProductSkuParam;
import com.emall.emallgoodsentity.entity.vo.ProductSkuVo;
import com.emall.emallgoodsservice.service.IProductSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productSku")
@Api(value = "ProductSkuController", tags = "商品sku-API")
public class ProductSkuController {

    @Autowired
    private IProductSkuService productSkuService;

    @ApiOperation(value = "查询商品sku信息", tags = "根据商品名获取商品sku信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<IPage<ProductSkuVo>> getProductSku(@RequestBody ProductSkuPageParam skuQueryParam) {
        return Result.success(productSkuService.getProductSku(skuQueryParam.getPage(), skuQueryParam.toParam(ProductSkuParam.class)));
    }

    @ApiOperation(value = "批量更新库存信息", tags = "根据商品id批量更新库存信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{pid}")
    @ResponseBody
    public Result update(@PathVariable Long pid, @RequestBody List<ProductSkuForm> skuStockList) {
        return Result.success(productSkuService.updateByPid(pid, skuStockList));

    }

}
