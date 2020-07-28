package com.emall.emallmanageplat.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.ProductForm;
import com.emall.emallmanageplat.entity.params.ProductEsParam;
import com.emall.emallmanageplat.entity.params.ProductParam;
import com.emall.emallmanageplat.entity.params.ProductQueryParam;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import com.emall.emallmanageplat.entity.vo.ProductVo;
import com.emall.emallmanageplat.service.IProductService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "ProductController", tags = "产品信息API")
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * TODO 首页关键字查询-转移到deskfronton中
     *
     * @param productEsParam
     * @return
     */
    @ApiOperation(value = "ES查询产品", notes = "根据关键字模糊查询产品信息")
    @PostMapping(value = "/getByKey")
    @ApiImplicitParam(paramType = "ProductEsParam", value = "关键字", required = true, dataType = "ProductEsParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<Page<ProductVo>> getProducts(@RequestBody ProductEsParam productEsParam) {
        return Result.success(productService.getProducts(productEsParam));
    }

    @ApiOperation(value = "查询产品", notes = "根据产品名、品牌、产品类别查询商品")
    @PostMapping(value = "/getByCondition")
    @ApiImplicitParam(paramType = "ProductQueryParam", value = "关键字", required = true, dataType = "ProductQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<ProductVo>> getResourceByCondition(@RequestBody ProductQueryParam productQueryParam) {
        return Result.success(productService.getResourceByCondition(productQueryParam.getPage(), productQueryParam.toParam(ProductParam.class)));
    }

    @ApiOperation(value = "添加产品", notes = "添加新产品")
    @PostMapping
    @ApiImplicitParam(paramType = "ProductForm", value = "添加产品表单", required = true, dataType = "ProductForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertProduct(@RequestBody ProductForm productForm) {
        return Result.success(productService.insertProduct(productForm.toPo(ProductsPo.class)));
    }

    @ApiOperation(value = "更新产品", notes = "根据产品id更新产品信息")
    @PutMapping("/{productId}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", value = "产品id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "ProductForm", value = "添加产品表单", required = true, dataType = "ProductForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateProduct(@PathVariable String productId, @RequestBody ProductForm productForm) {
        return Result.success(productService.updateProduct(productForm.toPo(productId, ProductsPo.class)));
    }

    @ApiOperation(value = "批量产品下架", notes = "根据产品id批量下架产品")
    @PutMapping("/publish/{productIds}")
    @ApiImplicitParam(paramType = "path", value = "产品id", required = true, dataType = "String")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result publishProduct(@PathVariable String productIds) {
        return Result.success(productService.publishProduct(productIds));
    }

    @ApiOperation(value = "批量删除产品", notes = "根据产品id批量删除产品")
    @DeleteMapping("/{productIds}")
    @ApiImplicitParam(paramType = "path", value = "产品id", required = true, dataType = "String")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteProduct(@PathVariable String productId) {
        return Result.success(productService.deleteProduct(productId));
    }


}
