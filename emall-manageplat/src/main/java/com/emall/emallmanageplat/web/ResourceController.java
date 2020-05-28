package com.emall.emallmanageplat.web;


import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import com.emall.emallmanageplat.service.IResourceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "查询资源", notes = "根据用户username查询用户所拥有的资源信息")
    @GetMapping
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<ResourcePo> getResourceByUsername(String username) {
        return Result.success(resourceService.getResourceByUsername(username));
    }

}
