package com.emall.emallgoodsservice.controller;

import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.ProductAttributeInsertForm;
import com.emall.emallgoodsentity.entity.form.ProductAttributeUpdateForm;
import com.emall.emallgoodsentity.entity.params.ProductAttributePageParam;
import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeValueVo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeVo;
import com.emall.emallgoodsservice.service.IProductAttributesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "ProductAttributeController", tags = "商品属性API")
@RequestMapping("/product-attribute")
public class ProductAttributeController {

    @Autowired
    private IProductAttributesService productAttributesService;

    @ApiOperation(value = "获取商品属性", notes = "根据类别获取商品属性")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/attributeList")
    public Result<ProductAttributeValueVo> getCategoryAttribute(@RequestBody ProductAttributePageParam param) {
        return Result.success(productAttributesService.getCategoryAttribute(param));
    }

    @ApiOperation(value = "更新商品属性", notes = "更新商品属性")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateAttributeById(@PathVariable Long id, @Valid @RequestBody ProductAttributeUpdateForm form) {
        ProductAttributePo productAttributePo = form.toPo(id, ProductAttributePo.class);
        return Result.success(productAttributesService.updateAttributeById(productAttributePo));
    }

    @ApiOperation(value = "更新商品属性状态", notes = "更新商品属性状态")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}/{status}")
    public Result updateAttributeStatusById(@PathVariable Long id, @PathVariable Integer status) {
        return Result.success(productAttributesService.updateAttributeStatusById(id, status));
    }

    @ApiOperation(value = "删除商品属性", notes = "删除商品属性")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result deleteAttributeById(@PathVariable String id) {
        return Result.success(productAttributesService.deleteAttributeById(id));
    }

    @ApiOperation(value = "插入属性(规格|参数)", notes = "插入属性参数(规格|参数)")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertAttributeParamById(@RequestBody ProductAttributeInsertForm form) {
        return Result.success(productAttributesService.insertAttributeParamById(form.getCategoryId(),form.toPo(ProductAttributePo.class)));
    }

    @ApiOperation(value = "根据分类id查看属性规格和属性参数", notes = "根据分类id查看属性规格和属性参数")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/getAttributeByCategoryId/{id}/{type}")
    public Result<List<ProductAttributeVo>> attributeByCategoryId(@PathVariable Long id, @PathVariable Integer type) {
        return Result.success(productAttributesService.attributeByCategoryId(id, type));
    }

}
