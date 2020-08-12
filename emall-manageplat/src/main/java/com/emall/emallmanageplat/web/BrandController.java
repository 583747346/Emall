package com.emall.emallmanageplat.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.BrandForm;
import com.emall.emallmanageplat.entity.params.BrandParam;
import com.emall.emallmanageplat.entity.params.BrandQueryParam;
import com.emall.emallmanageplat.entity.po.BrandPo;
import com.emall.emallmanageplat.entity.vo.BrandVo;
import com.emall.emallmanageplat.service.IBrandService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value = "BrandController", tags = "品牌信息API")
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @ApiOperation(value = "获取品牌信息", notes = "根据品牌id——获取品牌信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/{brandId}")
    public Result<BrandVo> getBrandById(@PathVariable Long brandId) {
        return Result.success(brandService.getBrandById(brandId));
    }

    @ApiOperation(value = "条件获取品牌信息", notes = "根据相关条件获取品牌信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<IPage<BrandVo>> getBrands(@RequestBody BrandQueryParam brandQueryParam) {
        return Result.success(brandService.getBrands(brandQueryParam.getPage(), brandQueryParam.toParam(BrandParam.class)));
    }

    @ApiOperation(value = "添加品牌信息", notes = "添加一个新的品牌")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertBrand(BrandForm brandForm) {
        return Result.success(brandService.insertBrand(brandForm));
    }

    @ApiOperation(value = "更新品牌信息", notes = "根据品牌id——更新一个品牌信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{brandId}")
    public Result updateBrand(@PathVariable Long brandId, BrandForm brandForm) {
        return Result.success(brandService.updateBrand(brandId, brandForm));
    }

    @ApiOperation(value = "批量删除品牌", notes = "根据品牌id——批量品牌")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{brandId}")
    public Result deleteBrand(@PathVariable String brandId) {
        return Result.success(brandService.deleteBrand(brandId));
    }

}
