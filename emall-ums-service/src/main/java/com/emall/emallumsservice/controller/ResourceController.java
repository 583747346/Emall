package com.emall.emallumsservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.form.ResourceForm;
import com.emall.emallumsentity.entity.params.ResourcePageParam;
import com.emall.emallumsentity.entity.params.ResourceParam;
import com.emall.emallumsentity.entity.po.ResourcePo;
import com.emall.emallumsentity.entity.vo.ResourceTreeVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;
import com.emall.emallumsservice.service.IResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@Api(value = "ResourceController", tags = "资源信息API")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @ApiOperation(value = "查询资源", notes = "根据用户userId查询用户所拥有的资源信息")
    @GetMapping(value = "/user/{username}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<ResourcePo> getResourceByUsername(@PathVariable("username") String username) {
        return Result.success(resourceService.getResourceByUsername(username));
    }

    @ApiOperation(value = "条件分页查询资源", notes = "条件分页查询所有资源列表")
    @PostMapping("/resourcelist")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<ResourceVo>> getResources(@RequestBody ResourcePageParam resourceQueryParam) {
        return Result.success(resourceService.getResources(resourceQueryParam.getPage(), resourceQueryParam.toParam(ResourceParam.class)));
    }

    @ApiOperation(value = "添加资源", notes = "添加资源信息")
    @PostMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertResources(@RequestBody ResourceForm resourceForm) {
        ResourcePo resourcePo = resourceForm.toPo(ResourcePo.class);
        return Result.success(resourceService.insertResources(resourcePo));
    }

    @ApiOperation(value = "删除资源", notes = "删除资源信息")
    @DeleteMapping("/{resourceId}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteResources(@PathVariable Long resourceId) {
        return Result.success(resourceService.deleteResources(resourceId));
    }

    @ApiOperation(value = "更新资源", notes = "根据资源id更新资源")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{resourceId}")
    public Result updateResource(@PathVariable Long resourceId, @RequestBody ResourceForm resourceForm) {
        return Result.success(resourceService.updateResource(resourceForm.toPo(resourceId, ResourcePo.class)));
    }


    @ApiOperation(value = "查询所有资源", notes = "查询所有资源信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/all")
    public Result<List<ResourcePo>> queryAll() {
        return Result.success(resourceService.getAll());
    }

    @ApiOperation(value = "查询所有请求方式", notes = "查询所有请求方式")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/getMethods")
    public Result<List<String>> getMethods() {
        return Result.success(resourceService.getMethods());
    }

    @ApiOperation(value = "查询所有请求类型", notes = "查询所有请求类型")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/getTypes")
    public Result<List<String>> getTypes() {
        return Result.success(resourceService.getTypes());
    }


    @ApiOperation(value = "按资源类型查询资源树", notes = "按资源类型查询资源树")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/getResourceTree")
    public Result<List<ResourceTreeVo>> getResourceByType() {
        return Result.success(resourceService.getResourceTree());
    }
}
