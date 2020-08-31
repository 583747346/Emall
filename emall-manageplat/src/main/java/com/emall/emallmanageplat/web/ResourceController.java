package com.emall.emallmanageplat.web;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.ResourceForm;
import com.emall.emallmanageplat.entity.params.ResourceParam;
import com.emall.emallmanageplat.entity.params.ResourceQueryParam;
import com.emall.emallweb.entity.po.ResourcePo;
import com.emall.emallmanageplat.entity.vo.ResourceVo;
import com.emall.emallmanageplat.service.IResourceService;
import io.swagger.annotations.*;
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
    @PostMapping("/getResources")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<ResourceVo>> getResources(@RequestBody ResourceQueryParam resourceQueryParam) {
        return Result.success(resourceService.getResources(resourceQueryParam.getPage(), resourceQueryParam.toParam(ResourceParam.class)));
    }

    @ApiOperation(value = "添加资源", notes = "添加资源信息")
    @PostMapping("/add")
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

}
