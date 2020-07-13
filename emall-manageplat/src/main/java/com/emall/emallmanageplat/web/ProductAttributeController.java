package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.ProductAttributeForm;
import com.emall.emallmanageplat.entity.params.ProductAttributeParam;
import com.emall.emallmanageplat.entity.params.ProductAttributeQueryParam;
import com.emall.emallmanageplat.entity.po.ProductAttributePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeVo;
import com.emall.emallmanageplat.service.IProductAttributeService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "ProductAttributeController", value = "商品属性API")
@RequestMapping("/productAttribute")
public class ProductAttributeController {

    private IProductAttributeService productAttributeService;

    @ApiOperation(value = "获取商品属性", notes = "根据属性名获取商品属性")
    @ApiImplicitParam(value = "商品属性名", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<ProductAttributeVo> getAttribute(@RequestBody ProductAttributeQueryParam param) {
        return Result.success(productAttributeService.getAttribute(param.getPage(),param.toParam(ProductAttributeParam.class)));
    }

    @ApiOperation(value = "更新商品属性", notes = "更新商品属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品属性唯一标识", required = true, dataType = "string"),
            @ApiImplicitParam(name = "ProductAttributeForm", value = "商品属性更新表单", required = true, dataType = "ProductAttributeForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable String id, @Valid @RequestBody ProductAttributeForm form) {
        ProductAttributePo productAttributePo = form.toPo(id, ProductAttributePo.class);
        return Result.success(productAttributeService.updateProductAttributeById(productAttributePo));
    }

    @ApiOperation(value = "删除商品属性", notes = "删除商品属性")
    @ApiImplicitParam(name = "id", value = "商品属性唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result updateUserById(@PathVariable String id) {
        return Result.success(productAttributeService.deleteProductAttributeById(id));
    }

    @ApiOperation(value = "插入新的商品属性", notes = "插入新的商品属性")
    @ApiImplicitParam(name = "ProductAttributeForm", value = "商品属性插入表单", required = true, dataType = "ProductAttributeForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result updateUserById(@PathVariable ProductAttributeForm form) {
        return Result.success(productAttributeService.insertProductAttribute(form.toPo(ProductAttributePo.class)));
    }

}
