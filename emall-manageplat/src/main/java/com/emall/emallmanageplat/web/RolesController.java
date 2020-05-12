package com.emall.emallmanageplat.web;


import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.service.IRolesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@Slf4j
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @ApiOperation(value = "查询角色", notes = "根据用户id查询用户所拥有的角色信息")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping(value = "/user/{userId}")
    public Result query(@PathVariable String userId) {
        log.debug("query with userId:{}", userId);
        return Result.success(rolesService.query(userId));
    }

}
