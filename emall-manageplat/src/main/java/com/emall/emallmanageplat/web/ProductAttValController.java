package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.ProductAttValInsertForm;
import com.emall.emallmanageplat.entity.form.ProductAttValUpdateForm;
import com.emall.emallmanageplat.entity.params.ProductAttValParam;
import com.emall.emallmanageplat.entity.params.ProductAttValQueryParam;
import com.emall.emallmanageplat.entity.po.ProductAttributeValuePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeValueVo;
import com.emall.emallmanageplat.service.IProductAttValService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "ProductAttValController", tags = "商品属性值API")
@RequestMapping("/productAttVal")
public class ProductAttValController {

    @Autowired
    private IProductAttValService productAttValService;

    @ApiOperation(value = "获取商品属性值", notes = "根据属性分类id/属性id获取商品属性值")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductAttributeValueVo> getAttribute(@RequestBody ProductAttValQueryParam param) {
        return Result.success(productAttValService.getAttributeVal(param.getPage(), param.toParam(ProductAttValParam.class)));
    }

    @ApiOperation(value = "更新商品属性", notes = "更新商品属性")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable Long id, @Valid @RequestBody ProductAttValUpdateForm form) {
        ProductAttributeValuePo productAttributeValuePo = form.toPo(id, ProductAttributeValuePo.class);
        return Result.success(productAttValService.updateProductAttributeById(productAttributeValuePo));
    }

    @ApiOperation(value = "删除商品属性值", notes = "删除商品属性值")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result updateUserById(@PathVariable String id) {
        return Result.success(productAttValService.deleteProductAttValById(id));
    }

    @ApiOperation(value = "插入新的商品属性值", notes = "插入新的商品属性值")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result updateUserById(@PathVariable ProductAttValInsertForm form) {
        return Result.success(productAttValService.insertProductAttVal(form.toPo(ProductAttributeValuePo.class)));
    }

}
