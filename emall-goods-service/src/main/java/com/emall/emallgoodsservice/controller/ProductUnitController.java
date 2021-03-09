package com.emall.emallgoodsservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.ProductUnitForm;
import com.emall.emallgoodsentity.entity.po.ProductUnitPo;
import com.emall.emallgoodsentity.entity.vo.ProductUnitVo;
import com.emall.emallgoodsservice.service.IProductUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品单位 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/product-unit")
@Api(value = "ProductUnitController", tags = "商品单位-API")
@Slf4j
public class ProductUnitController {

    @Autowired
    private IProductUnitService productUnitService;

    @ApiOperation(value = "获取商品单位信息", notes = "获取商品单位信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/productUnitList")
    public Result<IPage<ProductUnitVo>> productUnitList(@RequestBody Page page) {
        return Result.success(productUnitService.productUnitList(page));
    }

    @ApiOperation(value = "商品单位信息添加", notes = "商品单位信息添加")
    @PostMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertProductUnit(@RequestBody ProductUnitForm productUnitForm) {
        return Result.success(productUnitService.insertProductUnit(productUnitForm.toPo(ProductUnitPo.class)));
    }

    @ApiOperation(value = "商品单位信息删除", notes = "商品单位信息删除")
    @DeleteMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteProductUnit(@PathVariable Long id) {
        return Result.success(productUnitService.deleteProductUnit(id));
    }

    @ApiOperation(value = "商品单位信息更新", notes = "商品单位信息更新")
    @PutMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateProductUnit(@PathVariable Long id, @RequestBody ProductUnitForm productUnitForm) {
        return Result.success(productUnitService.updateProductUnit(productUnitForm.toPo(id, ProductUnitPo.class)));
    }

    @ApiOperation(value = "商品单位信息的状态更新", notes = "商品单位信息的状态更新")
    @PutMapping("/{id}/{status}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateStatusById(@PathVariable Long id, @PathVariable Integer status) {
        return Result.success(productUnitService.updateStatusById(id, status));
    }

}
