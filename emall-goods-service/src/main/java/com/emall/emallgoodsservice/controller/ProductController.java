package com.emall.emallgoodsservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.ProductForm;
import com.emall.emallgoodsentity.entity.params.ProductPageParam;
import com.emall.emallgoodsentity.entity.params.ProductParam;
import com.emall.emallgoodsentity.entity.vo.ProductVo;
import com.emall.emallgoodsservice.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "ProductController", tags = "产品信息API")
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * TODO 首页关键字查询-转移到deskfronton中
     * 这里ES无法使用IPage
     *
     * @param productEsParam
     * @return
     */
    /*@ApiOperation(value = "ES查询产品", notes = "根据关键字模糊查询产品信息")
    @PostMapping(value = "/getByKey")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<Page<ProductVo>> getProducts(@RequestBody ProductEsParam productEsParam) {
        return Result.success(productService.getProducts(productEsParam));
    }*/
    @ApiOperation(value = "查询产品", notes = "条件分页查询商品")
    @PostMapping(value = "/productlist")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    public Result<IPage<ProductVo>> getProductByCondition(@RequestBody ProductPageParam productQueryParam) {
        return Result.success(productService.getProductByCondition(productQueryParam.getPage(), productQueryParam.toParam(ProductParam.class)));
    }

    @ApiOperation(value = "添加新产品", notes = "添加新产品")
    @PostMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertProduct(@Valid @RequestBody ProductForm productForm) {
        return Result.success(productService.insertProduct(productForm));
    }

    @ApiOperation(value = "更新产品", notes = "根据产品id更新产品信息")
    @PutMapping("/{productId}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateProduct(@PathVariable Long productId, @RequestBody ProductForm productForm) {
        return Result.success(productService.updateProduct(productId, productForm));
    }

    @ApiOperation(value = "批量产品下架", notes = "根据产品id批量下架产品")
    @PutMapping("/off/{productIds}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result publishProduct(@PathVariable String productIds) {
        return Result.success(productService.publishProduct(productIds));
    }

    @ApiOperation(value = "批量删除产品", notes = "根据产品id批量删除产品")
    @DeleteMapping("/{productIds}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteProduct(@PathVariable String productId) {
        return Result.success(productService.deleteProduct(productId));
    }

    @ApiOperation(value = "商品状态更新", notes = "根据产品id修改上架状态|新老品状态|推荐状态|活动状态")
    @PutMapping("/updateStatus/{productId}/{status}/{type}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateProductStatus(@PathVariable Long productId, @PathVariable Integer status, @PathVariable String type) {
        return Result.success(productService.updateProductStatus(productId, status, type));
    }

    @ApiOperation(value = "商品详情", notes = "根据产品id查看商品详情")
    @GetMapping("/{productId}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result getProductDetailsById(@PathVariable Long productId) {
        return Result.success(productService.getProductDetailsById(productId));
    }

}
