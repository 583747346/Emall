package com.emall.emallmanageplat.web;


import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.form.ResourceForm;
import com.emall.emallmanageplat.entity.params.ResourceParam;
import com.emall.emallmanageplat.entity.params.ResourceQueryParam;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import com.emall.emallmanageplat.entity.vo.ResourceVo;
import com.emall.emallmanageplat.service.IResourceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@Api(value = "资源信息列表")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @ApiOperation(value = "查询资源", notes = "根据用户userId查询用户所拥有的资源信息")
    @GetMapping(value = "/user/{username}")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<ResourcePo> getResourceByUsername(String username) {
        return Result.success(resourceService.getResourceByUsername(username));
    }

    @ApiOperation(value = "条件分页查询资源", notes = "条件分页查询所有资源列表")
    @PostMapping("/getResources")
    @ApiImplicitParam(paramType = "ResourceQueryParam", value = "资源查询参数", required = true, dataType = "ResourceQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<ResourceVo> getResources(@RequestBody ResourceQueryParam resourceQueryParam) {
        return Result.success(resourceService.getResources(resourceQueryParam.getPage(),resourceQueryParam.toParam(ResourceParam.class)));
    }

    @ApiOperation(value = "添加资源", notes = "添加资源信息")
    @PostMapping
    @ApiImplicitParam(paramType = "ResourceForm", value = "资源查询参数", required = true, dataType = "ResourceForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertResources(@RequestBody ResourceForm resourceForm) {
        ResourcePo resourcePo = resourceForm.toPo(ResourcePo.class);
        return Result.success(resourceService.insertResources(resourcePo));
    }

    @ApiOperation(value = "删除资源", notes = "删除资源信息")
    @DeleteMapping("/{resourceId}")
    @ApiImplicitParam(paramType = "path",name = "",value = "资源唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteResources(@PathVariable String resourceId) {
        return Result.success(resourceService.deleteResources(resourceId));
    }

    @ApiOperation(value = "更新资源", notes = "根据资源id更新资源")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name = "resourceId",value = "资源唯一标识", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "ResourceForm", value = "资源更新表单信息", required = true, dataType = "ResourceForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{resourceId}")
    public Result updateGroup(@PathVariable String resourceId, @RequestBody ResourceForm resourceForm) {
        return Result.success (resourceService.updateResource (resourceForm.toPo (resourceId, ResourcePo.class)));
    }

}
