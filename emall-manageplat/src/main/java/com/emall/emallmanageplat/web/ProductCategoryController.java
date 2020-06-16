package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.form.ProductCatForm;
import com.emall.emallmanageplat.entity.params.ProductCatParam;
import com.emall.emallmanageplat.entity.params.ProductCatQueryParam;
import com.emall.emallmanageplat.entity.po.ProductCategoryPo;
import com.emall.emallmanageplat.entity.vo.ProductCategoryVo;
import com.emall.emallmanageplat.service.IProductCategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/productCat")
@Api(tags = "ProductCategoryController", value = "商品分类信息API")
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @ApiOperation(value = "获取商品分类信息", notes = "根据商品分类id获取商品分类列表")
    @ApiImplicitParam(name = "ProductCatQueryParam", value = "属性分类id", required = true, dataType = "ProductCatQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductCategoryVo> getAttribute(@RequestBody ProductCatQueryParam param) {
        return Result.success(productCategoryService.getCategory(param.getPage(), param.toParam(ProductCatParam.class)));
    }

    @ApiOperation(value = "获取商品分类信息", notes = "根据商品分类id获取商品分类列表")
    @ApiImplicitParam(value = "属性分类id", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/{id}")
    public Result<ProductCategoryVo> getAttributeById(@PathVariable String id) {
        return Result.success(productCategoryService.getAttributeById(id));
    }

    @ApiOperation(value = "更新商品分类", notes = "更新商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类唯一标识", required = true, dataType = "string"),
            @ApiImplicitParam(name = "ProductCatForm", value = "商品分类更新表单", required = true, dataType = "ProductCatForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable String id, @Valid @RequestBody ProductCatForm form) {
        ProductCategoryPo productCategoryPo = form.toPo(id, ProductCategoryPo.class);
        return Result.success(productCategoryService.updateProductCatById(productCategoryPo,form.getCatIds()));
    }

    @ApiOperation(value = "删除商品分类", notes = "删除商品分类")
    @ApiImplicitParam(name = "id", value = "商品分类唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result updateUserById(@PathVariable String id) {
        return Result.success(productCategoryService.deleteProductCatById(id));
    }

    @ApiOperation(value = "插入新的商品分类", notes = "插入新的商品分类")
    @ApiImplicitParam(name = "ProductCatForm", value = "商品分类插入表单", required = true, dataType = "ProductCatForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result updateUserById(@PathVariable ProductCatForm form) {
        return Result.success(productCategoryService.insertProductCat(form.toPo(ProductCategoryPo.class),form.getCatIds()));
    }

}