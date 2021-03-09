package com.emall.emallgoodsservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.ProductCatForm;
import com.emall.emallgoodsentity.entity.params.ProductCatPageParam;
import com.emall.emallgoodsentity.entity.params.ProductCatParam;
import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryLevelVo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryVo;
import com.emall.emallgoodsservice.service.IProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productCat")
@Api(value = "ProductCategoryController", tags = "商品分类信息API")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @ApiOperation(value = "获取商品分类信息列表", notes = "获取商品分类信息列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/categorylist")
    public Result<IPage<ProductCategoryVo>> getAttribute(@RequestBody ProductCatPageParam param) {
        return Result.success(productCategoryService.categoryList(param.getPage(), param.toParam(ProductCatParam.class)));
    }

    @ApiOperation(value = "获取商品分类信息", notes = "根据商品分类id获取商品分类列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/{id}")
    public Result<List<ProductCategoryVo>> getAttributeById(@PathVariable String id, @RequestParam int level) {
        return Result.success(productCategoryService.getAttributeById(id, level));
    }

    @ApiOperation(value = "更新商品分类", notes = "更新商品分类")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable Long id, @Valid @RequestBody ProductCatForm form) {
        ProductCategoryPo productCategoryPo = form.toPo(id, ProductCategoryPo.class);
        return Result.success(productCategoryService.updateProductCatById(productCategoryPo));
    }

    @ApiOperation(value = "删除商品分类", notes = "删除商品分类")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result updateUserById(@PathVariable String id) {
        return Result.success(productCategoryService.deleteProductCatById(id));
    }

    @ApiOperation(value = "插入新的商品分类", notes = "插入新的商品分类")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result updateUserById(@RequestBody ProductCatForm form) {
        return Result.success(productCategoryService.insertProductCat(form.toPo(ProductCategoryPo.class)));
    }

    @ApiOperation(value = "获取分类层级", notes = "获取分类层级")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/getCategory")
    public Result<List<ProductCategoryLevelVo>> getCategory() {
        return Result.success(productCategoryService.getCategory());
    }

    @ApiOperation(value = "分类导航栏状态更新", notes = "分类导航栏状态更新")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/updateStatusById/{categoryId}/{navStatus}")
    public Result updateStatusById(@PathVariable Long categoryId, @PathVariable int navStatus) {
        return Result.success(productCategoryService.updateStatusById(categoryId, navStatus));
    }

}
